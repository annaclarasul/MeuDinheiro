package com.senac.MeuDinheiro.service;

import com.senac.MeuDinheiro.model.Usuario;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioAuthenticationService {

    @Autowired
    private UsuarioService usuarioService;

    public Optional<Usuario> authenticateUser(String email, String senha) {
        return usuarioService.obterUsuarioPorEmailESenha(email, senha);
    }
    
}
