/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.MeuDinheiro.service;

import com.senac.MeuDinheiro.model.Categoria;
import com.senac.MeuDinheiro.model.Transacao;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class TransacaoService {

    private List<Transacao> transacoes = new LinkedList<>();
    private List<Categoria> categorias = new LinkedList<>();

    public TransacaoService() {
        // adicione categorias de exemplo
        categorias.add(new Categoria(1L, "Alimentação", "🍔"));
        categorias.add(new Categoria(2L, "Transporte", "🚗"));
        categorias.add(new Categoria(3L, "Lazer", "🍹"));
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void addTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public Categoria getCategoriaById(Long id) {
        return categorias.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Transacao getTransacaoById(Long id) {
        return transacoes.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void deleteTransacaoById(Long id) {
        transacoes.removeIf(t -> t.getId().equals(id));
    }

    public void updateTransacao(Long id, Transacao transacao) {
        if (transacao == null) {
            throw new IllegalArgumentException("A transação a ser atualizada não pode ser nula.");
        }

        if (Objects.nonNull(transacao.getId()) && !id.equals(transacao.getId())) {
            throw new IllegalArgumentException("Id da transação recebido como parâmetro é diferente do id da transação fornecido.");
        }

        transacao.setId(id);

    }

   

}
