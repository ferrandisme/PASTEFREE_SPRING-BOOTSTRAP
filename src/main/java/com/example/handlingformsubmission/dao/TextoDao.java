package com.example.handlingformsubmission.dao;

import com.example.handlingformsubmission.model.Texto;

import java.util.Optional;
import java.util.UUID;

public interface TextoDao {

    int insertTexto(Texto texto);

    Optional<Texto> selectTextoById(int id);
}
