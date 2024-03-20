
package com.senac.MeuDinheiro.model;
// src/main/java/com/senac/MeuDinheiro/model/Meta.java

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MetaDriver {
    private static final List<Meta> METAS = new ArrayList<>();
    @Autowired
    private Usuario user;

    public Meta create(Meta meta) {
        meta.setUser(user);
        METAS.add(meta);
        return meta;
    }

    public List<Meta> readAll() {
        return METAS;
    }

    public Meta update(Meta meta) {
        Meta existingMeta = getMeta(meta.getId());
        if (existingMeta != null) {
            int index = METAS.indexOf(existingMeta);
            METAS.set(index, meta);
            meta.setUser(user);
            return meta;
        }
        return null;
    }

    public boolean delete(int id) {
        Meta existingMeta = getMeta(id);
        if (existingMeta != null) {
            METAS.remove(existingMeta);
            return true;
        }
        return false;
    }

    public Meta getMeta(int id) {
        return METAS.stream()
          .filter(meta -> meta.getId() == id)
          .findFirst()
          .orElse(null);
    }
}
