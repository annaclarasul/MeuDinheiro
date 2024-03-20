/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.MeuDinheiro.service;

import com.senac.MeuDinheiro.model.Notificacao;
import com.senac.MeuDinheiro.model.Usuario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

public class NotificacaoService {

    private List<Notificacao> notificacoes;

    public NotificacaoService() {
        notificacoes = new ArrayList<>();
    }

    public void adicionarNotificacao(Notificacao notificacao) {
        notificacoes.add(notificacao);
    }

    public List<Notificacao> recuperarNotificacoes() {
        return new ArrayList<>(notificacoes);
    }

    public Notificacao recuperarNotificacaoPorId(int id) {
        for (Notificacao notificacao : notificacoes) {
            if (notificacao.getId() == id) {
                return notificacao;
            }
        }
        return null;
    }

    public List<Notificacao> recuperarNotificacoesPorUsuario(User user) {
        List<Notificacao> notificacoesPorUsuario = new ArrayList<>();
        for (Notificacao notificacao : notificacoes) {
            if (notificacao.getUser().equals(user)) {
                notificacoesPorUsuario.add(notificacao);
            }
        }
        return notificacoesPorUsuario;
    }

    public void marcarComoLida(int id) {
        Notificacao notificacao = recuperarNotificacaoPorId(id);
        if (notificacao != null) {
            notificacao.setReadStatus(true);
        }
    }

        public int getNumeroDeNotificacoesNaoLidas(User user) {
        List<Notificacao> notificacoesPorUsuario = recuperarNotificacoesPorUsuario(user);
        return (int) notificacoesPorUsuario.stream().filter(notificacao -> !notificacao.isReadStatus()).count();
    }

    public void excluirNotificacao(int id) {
        Notificacao notificacao = recuperarNotificacaoPorId(id);
        if (notificacao != null) {
            notificacoes.remove(notificacao);
        }
    }

    public void excluirNotificacoesPorUsuario(User user) {
        notificacoes.removeIf(notificacao -> notificacao.getUser().equals(user));
    }

    public List<Notificacao> recuperarNotificacoesPorUsuario(Optional<Usuario> user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

  

  
}
