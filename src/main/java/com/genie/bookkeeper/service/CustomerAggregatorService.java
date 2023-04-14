package com.genie.bookkeeper.service;


import com.genie.bookkeeper.scribe.ActivityScribe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerAggregatorService {

    @Autowired
    private ActivityScribe activityScribe;


}
