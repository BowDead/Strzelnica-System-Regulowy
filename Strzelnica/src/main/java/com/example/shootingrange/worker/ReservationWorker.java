package com.example.shootingrange.worker;

import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ReservationWorker {

    // Obsługuje zadanie wyszukiwania terminu
    @JobWorker(type = "searchDateToReservation")
    public Map<String, Object> searchDate() {
        boolean available = true;

        return Map.of("dateAvailable", available);
    }

    @JobWorker(type = "decideAboutReservation")
    public Map<String, Object> decideAboutReservation() {
        return Map.of("accept", true);
    }

    @JobWorker(type = "authorize-payment")
    public void authorizePayment() {
        System.out.println("Autoryzacja płatności przebiegła pomyślnie.");
    }
}
