package com.example.shootingrange.worker;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class WeaponAssignmentWorker {

    @JobWorker(type = "check-client-condition")
    public void checkCondition(final JobClient client, final ActivatedJob job) {
        // Symulacja weryfikacji (np. alkomat)
        boolean isUnderInfluence = false;

        if (isUnderInfluence) {
            // Jeśli klient jest pod wpływem, rzucamy błąd zdefiniowany w BPMN
            client.newThrowErrorCommand(job.getKey())
                    .errorCode("BAD_CONDITION")
                    .errorMessage("Klient jest pod wpływem alkoholu lub środków odurzających")
                    .send();
        } else {
            // Kontynuacja procesu
            client.newCompleteCommand(job.getKey())
                    .variables(Map.of("isUnderInfluence", false))
                    .send();
        }
    }

    @JobWorker(type = "instruct-client")
    public void instructClient() {
        System.out.println("Instruowanie klienta z obsługi wybranej jednostki broni.");
    }

    @JobWorker(type = "give-weapon")
    public void giveWeapon() {
        System.out.println("Broń i amunicja zostały wydane klientowi.");
    }
}
