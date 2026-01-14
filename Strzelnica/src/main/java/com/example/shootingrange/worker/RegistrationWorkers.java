package com.example.shootingrange.worker;

import io.camunda.client.annotation.JobWorker;
import io.camunda.client.annotation.Variable;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class RegistrationWorkers {

    private static final AtomicInteger clientIdCounter = new AtomicInteger(0);

    // Sprawdzenie stanu rejestracji klienta
    @JobWorker(type = "Check_client_registration")
    public Map<String, Object> checkClientRegistration(@Variable(name = "clientId") Integer clientId) {
        boolean clientRegistered;
        if (clientId == null) {
            clientId = clientIdCounter.incrementAndGet();
            clientRegistered = false;
            System.out.println("Nowy klient [ID: " + clientId + "]");
        } else {
            clientRegistered = true;
            System.out.println("Klient jest zarejestrowany [ID: " + clientId + "]");
        }

        return Map.of(
                "clientRegistered", clientRegistered,
                "clientId", clientId
        );
    }
}
