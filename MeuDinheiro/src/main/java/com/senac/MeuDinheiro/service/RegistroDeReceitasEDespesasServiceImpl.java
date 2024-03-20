
package com.senac.MeuDinheiro.service;

import com.senac.MeuDinheiro.model.RegistroDeReceitasEDespesas;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RegistroDeReceitasEDespesasServiceImpl implements RegistroDeReceitasEDespesasService {

    private final List<RegistroDeReceitasEDespesas> registros = new ArrayList<>();

    @Override
    public List<RegistroDeReceitasEDespesas> listarRegistros() {
        return registros;
    }

    @Override
    public RegistroDeReceitasEDespesas salvarRegistro(RegistroDeReceitasEDespesas registro) {
        registros.add(registro);
        return registro;
    }

}