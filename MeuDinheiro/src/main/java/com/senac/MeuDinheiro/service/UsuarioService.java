/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.MeuDinheiro.service;

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

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

  
    private final Map<Long, Usuario> usuarios = new HashMap<>();

    public Usuario criarUsuario(Usuario usuario) {
        usuario.setId(System.currentTimeMillis());
        usuarios.put(usuario.getId(), usuario);
        return usuario;
    }

  public Optional<Usuario> obterUsuarioPorId(int id) {
    return usuarios.values().stream()
            .filter(u -> u.getId() == id)
            .findFirst();
}

    public List<Usuario> obterTodosUsuarios() {
        return usuarios.values().stream().collect(Collectors.toList());
    }

    public Optional<Usuario> atualizarUsuario(Long id, Usuario usuario) {
        return usuarios.values().stream()
                .filter(u -> u.getId().equals(id))
                .peek(u -> {
                    u.setNome(usuario.getNome());
                    u.setEmail(usuario.getEmail());
                    u.setSenha(usuario.getSenha());
                })
                .findFirst();
    }

    public void excluirUsuario(Long id) {
        usuarios.remove(id);
    }

   public Optional<Usuario> obterUsuarioPorEmailESenha(String email, String senha) {
    return usuarios.values().stream()
            .filter(u -> u.getEmail().equals(email) && u.getSenha().equals(senha))
            .findFirst();
}

    public Optional<Usuario> obterUsuarioPorId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
