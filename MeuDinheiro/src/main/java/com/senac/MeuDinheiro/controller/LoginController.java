/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.MeuDinheiro.controller;

import com.senac.MeuDinheiro.model.Usuario;
import com.senac.MeuDinheiro.model.login;
import com.senac.MeuDinheiro.service.UsuarioAuthenticationService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsuarioAuthenticationService userAuthenticationService;

    @PostMapping
    public ResponseEntity<Usuario> login(@RequestBody login login) {
        Optional<Usuario> usuario = userAuthenticationService.authenticateUser(login.getEmail(), login.getSenha());
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}