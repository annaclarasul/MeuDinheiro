/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.MeuDinheiro.controller;

import com.senac.MeuDinheiro.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Usuario criarUsuario(Usuario user) {
        String sql = "INSERT INTO user (name, email, senha) VALUES (?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getNome());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getSenha());
            return ps;
        }, keyHolder);
        user.setId(keyHolder.getKey().longValue());
        return user;
    }

    public Usuario obterUsuarioPorId(Long id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new UsuarioRowMapper());
    }

    public List<Usuario> obterTodosUsuarios() {
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, new UsuarioRowMapper());
    }

    public Usuario atualizarUsuario(Usuario user) {
        String sql = "UPDATE user SET name = ?, email = ?, senha = ? WHERE id = ?";
        jdbcTemplate.update(sql, user.getNome(), user.getEmail(), user.getSenha(), user.getId());
        return user;
    }

    public void ExcluirUsuario(Long id) {
        String sql = "DELETE FROM user WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    private static class UsuarioRowMapper implements RowMapper<Usuario> {

    public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String nome = rs.getString("name");
        String email = rs.getString("email");
        String senha = rs.getString("senha");
        Usuario user;
        user = new Usuario(id, nome, email, senha);
        return user;
    }
}
}
