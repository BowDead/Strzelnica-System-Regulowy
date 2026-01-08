package com.example.shootingrange.worker;


import io.camunda.client.annotation.JobWorker;
import io.camunda.client.annotation.Variable;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RegistrationWorkers {
    @JobWorker(type = "check-age-worker") // Typ musi być taki sam jak w BPMN
    public Map<String, Object> checkAge(@Variable(name = "age") Integer age) {
        boolean isAdult = age != null && age >= 18;
        return Map.of("isAdult", isAdult); // Zmienna wróci do procesu i ustawi bramkę
    }
}
