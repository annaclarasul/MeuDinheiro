package com.senac.MeuDinheiro.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transacao {

    public Object getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   public class transacao {
    private Long id;
    private String descricao;
    private BigDecimal valor;
    private LocalDate data;
    private Categoria categoria;
    
       public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public transacao(Long id, String descricao, BigDecimal valor, LocalDate data, Categoria categoria) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.categoria = categoria;
    }
    
 

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

   }
}
