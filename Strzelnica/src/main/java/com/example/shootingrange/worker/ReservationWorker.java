package com.example.shootingrange.worker;

import io.camunda.client.annotation.JobWorker;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ReservationWorker {

    @JobWorker(type = "searchDateToReservation")
    public Map<String, Object> searchDate() {
        boolean available = true;
        System.out.println("Dostępna data rezerwacji: " + available);
        return Map.of("dateAvailable", available);
    }

    @JobWorker(type = "decideAboutReservation")
    public Map<String, Object> decideAboutReservation() {
        boolean accept = true;
        System.out.println("Akceptacja rezerwacji: " + accept);
        return Map.of("accept", accept);
    }

    @JobWorker(type = "authorize-payment")
    public void authorizePayment() {
        System.out.println("Pomyślna autoryzacja zapłaty za sesje");
    }

    @JobWorker(type = "check_positions_and_instructors")
    public Map<String, Object> checkPositionsAndInstructors() {
        boolean positionsAndInstructors = true;
        System.out.println("Przydzielenie pozycji i instruktora: " + positionsAndInstructors);
        return Map.of("positionsAndInstructors", positionsAndInstructors);
    }

    @JobWorker(type = "client_action_check")
    public Map<String, Object> clientActionCheck() {
        boolean clientActionAccepted = true;
        System.out.println("Akcja klienta: " + clientActionAccepted);
        return Map.of("clientActionAccepted", clientActionAccepted);
    }
}
