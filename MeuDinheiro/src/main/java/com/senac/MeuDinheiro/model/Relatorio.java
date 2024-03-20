/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.MeuDinheiro.model;

import java.time.LocalDate;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Relatorio {
    private String nome;
    private String descricao;
    private LocalDate dataGeracao;
    private Double totalReceitas;
    private Double totalDespesas;
    private Double saldo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataGeracao() {
        return dataGeracao;
    }

    public void setDataGeracao(LocalDate dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    public Double getTotalReceitas() {
        return totalReceitas;
    }

    public void setTotalReceitas(Double totalReceitas) {
        this.totalReceitas = totalReceitas;
    }

    public Double getTotalDespesas() {
        return totalDespesas;
    }

    public void setTotalDespesas(Double totalDespesas) {
        this.totalDespesas = totalDespesas;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Relatorio(String nome, String descricao, LocalDate dataGeracao, Double totalReceitas, Double totalDespesas, Double saldo) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataGeracao = dataGeracao;
        this.totalReceitas = totalReceitas;
        this.totalDespesas = totalDespesas;
        this.saldo = saldo;
    }

    
}