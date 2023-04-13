package com.example.bookkeeper.controller;

import com.example.bookkeeper.scribe.ActivityScribe;
import com.example.bookkeeper.scribe.ActivityScribeLoggingLevels;
import com.keeper.openapi.api.PetsApi;
import com.keeper.openapi.model.Pet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TruckerController implements PetsApi {

    private final ActivityScribe scribe;

    public TruckerController(ActivityScribe scribe){
        this.scribe = scribe;
    }

    @Override
    public ResponseEntity<Void> createPets(){
        ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        scribe.logEntry(this.getClass(), "Create pets endpoint invoked in controller", ActivityScribeLoggingLevels.INFO);
        return responseEntity;
    }

    @Override
    public ResponseEntity<List<Pet>> listPets(Integer limit){
        ResponseEntity<List<Pet>> responseEntity = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        scribe.logEntry(this.getClass(), "List pets endpoint invoked in controller", ActivityScribeLoggingLevels.INFO);
        return responseEntity;
    }

    @Override
    public ResponseEntity<List<Pet>> showPetById(String petID){
        ResponseEntity<List<Pet>> responseEntity = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        scribe.logEntry(this.getClass(), "Show pets endpoint invoked in controller", ActivityScribeLoggingLevels.INFO);
        return responseEntity;
    }
}