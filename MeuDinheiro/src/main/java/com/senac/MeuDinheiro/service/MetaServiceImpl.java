package com.senac.MeuDinheiro.service;

import com.senac.MeuDinheiro.model.Meta;
import java.util.ArrayList;
import java.util.List;

public class MetaServiceImpl implements MetaService {
    private List<Meta> metas;

    public MetaServiceImpl() {
        metas = new ArrayList<>();
    }

    @Override
    public List<Meta> readAll() {
        return metas;
    }

    @Override
    public Meta create(Meta meta) {
        metas.add(meta);
        return meta;
    }

    @Override
    public Meta update(Meta meta) {
        int index = metas.indexOf(meta);
        if (index != -1) {
            metas.set(index, meta);
        }
        return meta;
    }

    @Override
    public boolean delete(int id) {
        Meta meta = metas.stream().filter(m -> m.getId() == id).findFirst().orElse(null);
        return metas.remove(meta);
    }
}
