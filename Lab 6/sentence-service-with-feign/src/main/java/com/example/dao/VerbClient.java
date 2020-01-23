package com.example.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("lab-4-verb")
public interface VerbClient {

    @RequestMapping(value = "/" ,method = RequestMethod.GET)
    String getVerb();
}
