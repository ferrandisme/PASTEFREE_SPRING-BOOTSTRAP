package com.example.handlingformsubmission.dao;

import com.example.handlingformsubmission.model.Texto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("fakeDB")
public class FakeDB implements TextoDao{

    /*
        Class created only for testing pourposes. Do not use it on production
     */

    List<Texto> DB = new ArrayList<>();

    @Override
    public int insertTexto(Texto texto) {
        if(texto.getId() == 0)
            texto.setId(generateRandomInt());
        DB.add(texto);
        return texto.getId();
    }

    @Override
    public Optional<Texto> selectTextoById(int id) {
        return DB.stream()
                .filter(texto -> texto.getId() == id)
                .findFirst();
    }


}
