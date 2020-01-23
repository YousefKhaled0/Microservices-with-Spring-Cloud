package com.example;

import com.example.config.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@EnableDiscoveryClient
@SpringBootApplication
@RibbonClient(name="sentence-service" , configuration = RibbonConfig.class)
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}