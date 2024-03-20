
package com.senac.MeuDinheiro.model;
import java.time.LocalDate;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

public class Orcamento {
    private int id;
    private String categoria;
    private double quantidade;
    private LocalDate startDate;
    private LocalDate endDate;
    private User user;

    public Orcamento(int id, String categoria, double quantidade, LocalDate startDate, LocalDate endDate, User user) {
        this.id = id;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.startDate = startDate;
        this.endDate = endDate;
        this.user = user;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
