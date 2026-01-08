package com.example.shootingrange.worker;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ShootingSessionWorkers {

    @JobWorker(type = "client-takes-aim")
    public void handleTakesAim(final JobClient client, final ActivatedJob job) {
        // Logika: Klient celuje
        System.out.println("Klient celuje do celu...");
    }

    @JobWorker(type = "client-shoots-target")
    public Map<String, Object> handleShootsTarget() {
        // Logika: Oddanie strzału
        System.out.println("Strzał oddany!");

        return Map.of("client_continue", Math.random() > 0.3);
    }

    @JobWorker(type = "add-to-blacklist")
    public void handleBlacklist(final ActivatedJob job) {
        // Wywoływane w przypadku błędu niebezpiecznego zachowania
        System.err.println("Klient dodany do czarnej listy!");
    }
}
