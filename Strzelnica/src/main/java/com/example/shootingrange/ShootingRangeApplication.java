package com.example.shootingrange;

import io.camunda.zeebe.spring.client.annotation.Deployment;
import io.camunda.zeebe.spring.client.EnableZeebeClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableZeebeClient
@Deployment(resources = "classpath:bpmn/*.bpmn")
public class ShootingRangeApplication {

  public static void main(String[] args) {
    SpringApplication.run(ShootingRangeApplication.class, args);
    System.out.println("Aplikacja strzelnicy została uruchomiona!");
  }
}