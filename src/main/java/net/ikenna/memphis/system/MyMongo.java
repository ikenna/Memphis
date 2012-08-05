package net.ikenna.memphis.system;

import com.mongodb.Mongo;
import com.mongodb.WriteConcern;

import java.net.UnknownHostException;

enum MyMongo {
    INSTANCE;

    final Mongo mongo;

    MyMongo() {
        try {
            mongo = new Mongo("localhost", 27017);
            mongo.setWriteConcern(WriteConcern.SAFE);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
