/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.MeuDinheiro.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.senac.MeuDinheiro.model.Notificacao;
import com.senac.MeuDinheiro.model.Usuario;
import com.senac.MeuDinheiro.service.NotificacaoService;
import com.senac.MeuDinheiro.service.UsuarioService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notificacoes")
public class NotificacaoController {

    @Autowired
    private NotificacaoService notificacaoService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<Notificacao> recuperarNotificacaoPorId(@PathVariable int id) {
        Notificacao notificacao = notificacaoService.recuperarNotificacaoPorId(id);
        if (notificacao == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(notificacao);
    }

    @GetMapping("/usuario/{userId}")
    public ResponseEntity<List<Notificacao>> recuperarNotificacoesPorUsuario(@PathVariable int userId) {
        Optional<Usuario> user = usuarioService.obterUsuarioPorId(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        List<Notificacao> notificacoes = notificacaoService.recuperarNotificacoesPorUsuario(user);
        return ResponseEntity.ok(notificacoes);
    }


}
