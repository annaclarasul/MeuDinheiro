package com.senac.MeuDinheiro.model;

import java.time.LocalDate;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

@EntityScan

public class Notificacao {

    private int id;
    private String tipo;
    private String mensagem;
    private boolean readStatus;
    private LocalDate data;
    private User user;

    public Notificacao(int id, String tipo, String mensagem, boolean readStatus, LocalDate data, User user) {
        this.id = id;
        this.tipo = tipo;
        this.mensagem = mensagem;
        this.readStatus = readStatus;
        this.data = data;
        this.user = user;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public boolean isReadStatus() {
        return readStatus;
    }

    public void setReadStatus(boolean readStatus) {
        this.readStatus = readStatus;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
