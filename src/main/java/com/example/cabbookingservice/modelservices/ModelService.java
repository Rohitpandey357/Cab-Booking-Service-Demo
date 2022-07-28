package com.example.cabbookingservice.modelservices;

/*
 * A generic interface to interact with the database.
 */

public interface ModelService<U> {
    public void add(U u);
}
