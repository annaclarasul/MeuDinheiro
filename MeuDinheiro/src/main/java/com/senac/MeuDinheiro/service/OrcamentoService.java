package com.senac.MeuDinheiro.service;
import com.senac.MeuDinheiro.model.Orcamento;
import java.util.ArrayList;
import java.util.List;

public class OrcamentoService {

    private List<Orcamento> orcamentos;

    public OrcamentoService() {
        orcamentos = new ArrayList<>();
    }

    public void adicionarOrcamento(Orcamento orcamento) {
        orcamentos.add(orcamento);
    }

    public void atualizarOrcamento(Orcamento orcamento) {
        int index = orcamentos.indexOf(orcamento);
        if (index != -1) {
            orcamentos.set(index, orcamento);
        }
    }

    public void excluirOrcamento(Orcamento orcamento) {
        orcamentos.remove(orcamento);
    }

    public List<Orcamento> recuperarOrcamentos() {
        return new ArrayList<>(orcamentos);
    }

    public Orcamento recuperarOrcamentoPorId(int id) {
        for (Orcamento orcamento : orcamentos) {
            if (orcamento.getId() == id) {
                return orcamento;
            }
        }
        return null;
    }
}