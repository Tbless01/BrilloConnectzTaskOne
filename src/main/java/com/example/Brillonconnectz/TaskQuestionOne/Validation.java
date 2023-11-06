package com.example.Brillonconnectz.TaskQuestionOne;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Validation {

    public static void main(String[] args) {
        Map<String, String> inputFields = new HashMap<>();
        inputFields.put("Username", "user123");
        inputFields.put("Email", "mytest@gmail.com");
        inputFields.put("Password", "P@ssw0rd");
        inputFields.put("Date of Birth", "2000-01-01");

        Map<String, String> validationErrors = validateFields(inputFields);

        if (validationErrors.isEmpty()) {
            System.out.println("All fields are valid.");
        } else {
            for (Map.Entry<String, String> entry : validationErrors.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    public static Map<String, String> validateFields(Map<String, String> inputFields) {
        Map<String, String> validationErrors = new HashMap<>();

        for (Map.Entry<String, String> entry : inputFields.entrySet()) {
            String fieldName = entry.getKey();
            String value = entry.getValue();

            if (fieldName.equals("Username")) {
                if (value.isEmpty() || value.length() < 4) {
                    validationErrors.put(fieldName, "Username: should not be empty and should have at least 4 characters.");
                }
            } else if (fieldName.equals("Email")) {
                if (value.isEmpty() || !isValidEmail(value)) {
                    validationErrors.put(fieldName, "Email: should not be empty and should be a valid email address.");
                }
            } else if (fieldName.equals("Password")) {
                if (value.isEmpty() || !isStrongPassword(value)) {
                    validationErrors.put(fieldName, "Password: should not be empty, and must be a strong password.");
                }
            } else if (fieldName.equals("Date of Birth")) {
                if (value.isEmpty() || !isDateOfBirthValid(value)) {
                    validationErrors.put(fieldName, "Date of Birth: should not be empty and should be 16 years or greater than 16 years.");
                }
            }
        }
        return validationErrors;
    }

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(emailRegex);
    }

    public static boolean isStrongPassword(String password) {
        String passwordRegex = "^(?=.*[A-Z])(?=.*[!@#$%^&*])(?=.*[0-9]).{8,}$";
        return password.matches(passwordRegex);
    }

    public static boolean isDateOfBirthValid(String dateOfBirth) {
        LocalDate birthDate = LocalDate.parse(dateOfBirth);
        LocalDate currentDate = LocalDate.now();
        return birthDate.isBefore(currentDate.minusYears(16));
    }
}