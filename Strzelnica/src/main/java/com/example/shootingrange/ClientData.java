package com.example.shootingrange;

import java.util.HashMap;
import java.util.Map;

public class ClientData {

    public static Map<String, Object> getClientVariables() {
        Map<String, Object> variables = new HashMap<>();
        variables.put("clientId", 2);
        variables.put("clientAction", "reserve");
        variables.put("age", 20);
        variables.put("hasLicense", true);
        variables.put("hasTraining", false);

        return variables;
    }
}
