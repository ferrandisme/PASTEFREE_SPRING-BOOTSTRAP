package com.example.handlingformsubmission.service;

import com.example.handlingformsubmission.dao.TextoDao;
import com.example.handlingformsubmission.model.Texto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TextoService {

    private final TextoDao textoDao;

    @Autowired
    public TextoService(@Qualifier("fakeDB") TextoDao textoDao) {
        this.textoDao = textoDao;
    }

    public int addTexto(Texto texto) {
        return textoDao.insertTexto(texto);
    }

    public Optional<Texto> getTextoById(int id){
        return textoDao.selectTextoById(id);
    }
}
