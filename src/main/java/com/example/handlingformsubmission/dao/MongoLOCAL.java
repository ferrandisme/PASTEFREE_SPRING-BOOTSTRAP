package com.example.handlingformsubmission.dao;

import com.example.handlingformsubmission.model.Texto;
import com.mongodb.Cursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Repository("mongoLOCAL")
public class MongoLOCAL implements TextoDao{

    MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection collection;


    public void connect(){
        try {
            mongoClient = new MongoClient();
            database = mongoClient.getDatabase("default");
            collection = database.getCollection("pastes");
        }
        catch (Exception e){
            System.err.println("Algo ha ido mal al crear el socket");
            e.printStackTrace();
        }
    }

    @Override
    public int insertTexto(Texto texto) {
        connect();
        if(texto.getId() == 0) // 0 se entiende como no asignado
            texto.setId(generateRandomInt());
        Document newTexto = new Document("_id", texto.getId())
                .append("content", texto.getContent());
        collection.insertOne(newTexto);
        return texto.getId();
    }

    public int generateRandomInt(){
        int randomNum = ThreadLocalRandom.current().nextInt(-2100000000, 2100000000 + 1);
        if(selectTextoById(randomNum).equals(Optional.empty()))
            return randomNum;
        else
            return  generateRandomInt();
    }

    @Override
    public Optional<Texto> selectTextoById(int id) {
        connect();
        Texto texto = null;
        try {
            Document idTexto = new Document("_id", id);
            Document JSONTexto = (Document) collection.find(idTexto).first();
            texto = new Texto();
            texto.setContent((String)JSONTexto.get("content"));
            texto.setId((int)JSONTexto.get("_id"));
        }catch(Exception e){
            System.out.println("No se ha podido encontrar el objeto");
            return Optional.empty();
            //e.printStackTrace();
        }
        if(texto == null)
            return Optional.empty();
        else
            return Optional.of(texto);
    }
}
