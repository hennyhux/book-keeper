package com.example.bookkeeper.controller;

import com.keeper.openapi.api.PingApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class PingController implements PingApi {
    @Override
    public ResponseEntity<Void> ping() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
