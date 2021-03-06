package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.services.SentenceService;

@RestController
public class SentenceController {

    @Autowired
    private SentenceService sentenceService;

    @RequestMapping("/sentence")
    public String getSentence() {
       return sentenceService.getSentence();
    }
}
