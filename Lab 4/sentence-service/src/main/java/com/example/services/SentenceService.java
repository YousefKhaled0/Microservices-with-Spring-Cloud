package com.example.services;

import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class SentenceService {

    @Autowired
    private EurekaClient client;

    public String getSentence() {
        return getWord("lab-4-subject") + " " + getWord("lab-4-verb");
    }

    public String getWord(String service) {
        Application App = client.getApplication(service);
        try {
            URI uri = new URI(App.getInstances().get(0).getHomePageUrl());
            return (new RestTemplate()).getForObject(uri, String.class);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return null;
    }
}
