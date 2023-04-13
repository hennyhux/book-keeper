package com.example.bookkeeper.controller;

import com.example.bookkeeper.scribe.ActivityScribe;
import com.example.bookkeeper.scribe.ActivityScribeLoggingLevels;
import com.keeper.openapi.api.PetsApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TruckerController implements PetsApi {

    private final ActivityScribe scribe;

    public TruckerController(ActivityScribe scribe){
        this.scribe = scribe;
    }

    @Override
    public ResponseEntity<Void> createPets(){
        ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        scribe.logEntry(this.getClass(), "DIZZY NUTS!", ActivityScribeLoggingLevels.INFO);
        return responseEntity;
    }

}