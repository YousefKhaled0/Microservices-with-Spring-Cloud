package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SentenceService {

    @Autowired
    private RestTemplate restTemplate;

    public String getSentence() {
        return getWord("lab-4-subject") + " " + getWord("lab-4-verb");
    }

    public String getWord(String service) {
        return restTemplate.getForObject("http://" + service + "/", String.class);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
