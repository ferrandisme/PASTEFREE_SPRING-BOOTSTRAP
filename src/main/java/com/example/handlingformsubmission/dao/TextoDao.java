package com.example.handlingformsubmission.dao;

import com.example.handlingformsubmission.model.Texto;

import java.net.UnknownHostException;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public interface TextoDao {

    int insertTexto(Texto texto);

    Optional<Texto> selectTextoById(int id);

    default int generateRandomInt(){
        int randomNum = ThreadLocalRandom.current().nextInt(-2100000000, 2100000000 + 1);
        if(selectTextoById(randomNum).equals(Optional.empty()))
            return randomNum;
        else
            return  generateRandomInt();
    }
}
