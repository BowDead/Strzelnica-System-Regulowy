package com.example.shootingrange.worker;

import io.camunda.client.annotation.JobWorker;
import io.camunda.client.annotation.Variable;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Component
public class ReservationWorker {

    @JobWorker(type = "searchDateToReservation")
    public Map<String, Object> searchDateToReservation(
            @Variable(name = "sessionDate") String sessionDateStr){

        Map<String, Object> result = new HashMap<>();
        LocalDate sessionDate = LocalDate.parse(sessionDateStr);
        boolean dateAvailable = false;
        boolean clientAcceptsDate = Math.random() < 0.5;

        if (dateAvailable == false && clientAcceptsDate) {
            System.out.println("Data niedostępna [data: " + sessionDate + "]");
            sessionDate = sessionDate.plusDays(1);
        }
        else {
            System.out.println("Data dostępna: " + sessionDate + "\n");
            dateAvailable = true;
        }

        result.put("dateAvailable", dateAvailable);
        result.put("sessionDate", sessionDate.toString());

        return result;
    }



    // Decyzja o rezerwacji
    @JobWorker(type = "decideAboutReservation")
    public Map<String, Object> decideAboutReservation() {
        boolean accept = true;
        System.out.println("Akceptacja rezerwacji: " + accept);
        return Map.of("accept", accept);
    }

    // Autoryzacja płatności
    @JobWorker(type = "authorize-payment")
    public void authorizePayment() {
        System.out.println("Pomyślna autoryzacja zapłaty za sesję");
    }

    // Sprawdzenie dostępności pozycji i instruktorów
    @JobWorker(type = "checkAvailablePositionsAndInstructors")
    public Map<String, Object> checkPositionsAndInstructors() {
        boolean positionsAndInstructors = true;
        System.out.println("Przydzielenie pozycji i instruktora: " + positionsAndInstructors);
        return Map.of("positionsAndInstructors", positionsAndInstructors);
    }

    // Sprawdzenie akcji klienta
    @JobWorker(type = "client_action_check")
    public Map<String, Object> clientActionCheck() {
        boolean clientActionAccepted = true;
        System.out.println("Akcja klienta zaakceptowana: " + clientActionAccepted);
        return Map.of("clientActionAccepted", clientActionAccepted);
    }
}
