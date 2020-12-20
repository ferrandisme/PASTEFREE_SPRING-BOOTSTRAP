/*package com.example.handlingformsubmission.dao;

import com.example.handlingformsubmission.model.Texto;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.bson.Document;

import java.net.UnknownHostException;
import java.rmi.server.ExportException;
import java.util.Optional;

@Repository("mongoDB")
public class MongoDAO implements TextoDao {

    String password = "lepFsbcAaiuS95iv";
    MongoClientURI uri;
    MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection collection;

    @Autowired
    public MongoDAO(){
        try {
            uri = new MongoClientURI(
                    "mongodb+srv://admin:" + password + "@cluster0.4kxx6.mongodb.net/default?retryWrites=true&w=majority");
            mongoClient = new MongoClient(uri);
            database = mongoClient.getDatabase("default");
            collection = database.getCollection("pastes");
            System.out.println("Resultado " + uri + " " + mongoClient + " " + collection);
        }
        catch (Exception e){
            System.err.println("Algo ha ido mal al crear el socket");
            e.printStackTrace();
        }
    }


    @Override
    public int insertTexto(Texto texto) {
        //create();
        try {
            Document newTexto = new Document("id", texto.getId())
                    .append("content", texto.getContent());
            collection.insertOne(newTexto);
        }catch (Exception e)
        {
            System.err.println("Algo ha ido mal al insertar el Documento");
            e.printStackTrace();
        }
        return texto.getId();
    }

    @Override
    public Optional<Texto> selectTextoById(int id) {
        //create();
        return Optional.empty();
    }

}
*/