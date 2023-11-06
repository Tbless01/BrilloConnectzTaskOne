package com.example.Brillonconnectz.TaskQuestionOne;

import java.util.HashMap;
import java.util.Map;

public class ConcurrentValidation {

    public static void main(String[] args) {
        Map<String, String> inputFields = Map.of(
                "Username", "user123",
                "Email", "test@example.com",
                "Password", "P@ssw0rd",
                "Date of Birth", "2000-01-01"
        );

        Map<String, String> validationErrors = validateFieldsConcurrently(inputFields);

        if (validationErrors.isEmpty()) {
            System.out.println("All fields are valid.");
        } else {
            validationErrors.forEach((key, value) -> System.out.println(key + ": " + value));
        }
    }

    public static Map<String, String> validateFieldsConcurrently(Map<String, String> inputFields) {
        return inputFields.entrySet().parallelStream()
                .filter(entry -> !validateField(entry.getKey(), entry.getValue()))
                .collect(HashMap::new, (m, e) -> m.put(e.getKey(), e.getValue()), HashMap::putAll);
    }

    public static boolean validateField(String fieldName, String value) {
        if (fieldName.equals("Username")) {
            return !value.isEmpty() && value.length() >= 4;
        } else if (fieldName.equals("Email")) {
            return !value.isEmpty() && Validation.isValidEmail(value);
        } else if (fieldName.equals("Password")) {
            return !value.isEmpty() && Validation.isStrongPassword(value);
        } else if (fieldName.equals("Date of Birth")) {
            return !value.isEmpty() && Validation.isDateOfBirthValid(value);
        }
        return true;
    }

}