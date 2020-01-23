package com.example.services;

import com.example.dao.SubjectClient;
import com.example.dao.VerbClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SentenceService {

    @Autowired
    private SubjectClient subjectClient;

    @Autowired
    private VerbClient verbClient;

    public String getSentence (){
        return subjectClient.getSubject() + " " + verbClient.getVerb();
    }

}
