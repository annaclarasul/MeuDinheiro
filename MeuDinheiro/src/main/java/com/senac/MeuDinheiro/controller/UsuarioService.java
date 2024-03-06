/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.MeuDinheiro.controller;

import com.senac.MeuDinheiro.model.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Usuario criarUsuario(Usuario user) {
    String sql = "INSERT INTO user (nome, email, senha) VALUES (?, ?, ?)";
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(connection -> connection.prepareStatement(sql), user.getNome(), user.getEmail(), user.getSenha(), keyHolder);
    user.setId(keyHolder.getKey().longValue());
    return user;
}



    public Usuario getUserById(Long id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserRowMapper());
    }

    public List<Usuario> getAllUsers() {
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    public Usuario updateUser(Usuario user) {
        String sql = "UPDATE user SET name = ?, email = ?, password = ? WHERE id = ?";
        jdbcTemplate.update(sql, user.getNome(), user.getEmail(), user.getSenha(), user.getId());
        return user;
    }

    public void deleteUser(Long id) {
        String sql = "DELETE FROM user WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

 private static class UserRowMapper implements RowMapper<Usuario> {
    public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String nome = rs.getString("nome");
        String email = rs.getString("email");
        String senha = rs.getString("senha");
        Usuario user;
        user = new Usuario(nome, email, senha);
        user.setId(id);
        return user;
    }
}
}

