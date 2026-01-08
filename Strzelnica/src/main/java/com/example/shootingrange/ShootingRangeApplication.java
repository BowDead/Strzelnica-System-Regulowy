package com.example.shootingrange;

import io.camunda.client.annotation.Deployment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Deployment(resources = "classpath:bpmn/*.bpmn")
public class ShootingRangeApplication {

  public static void main(String[] args) {
    SpringApplication.run(ShootingRangeApplication.class, args);
    System.out.println("Aplikacja strzelnicy została uruchomiona!");
  }
}