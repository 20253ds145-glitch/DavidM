package com.example.demolistview.services;

import com.example.demolistview.repositories.PersonFilesRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    PersonFilesRepository repo = new PersonFilesRepository();
    public List<String> loadDataForListView() throws IOException {
        List<String> lines = repo.readAllLines();
        List<String> result = new ArrayList<>();

        for (String line : lines) {
            if (line == null || line.isBlank()) continue;

            String[] parts = line.split(",");
            String name = parts[0];
            String email = parts[1];
            String age = (parts.length > 2) ? parts[2] : "N/A";

            result.add("Nombre: " + name + " | " + email + " | Edad: " + age);
        }
        return result;
    }

    public void addPerson(String name, String email, String age) throws Exception {

        validate(name, email, age);

        repo.appendNewLine(name + "," + email + "," + age);
    }




    private void validate(String name, String email, String age) throws Exception {
        if (name.isBlank() || email.isBlank() || age.isBlank()) {
            throw new Exception("Todos los campos son obligatorios.");
        }

        int ageInt;
        try {
            ageInt = Integer.parseInt(age.trim());
        } catch (NumberFormatException e) {
            throw new Exception("La edad debe ser un número entero (ej: 25).");
        }

        if (ageInt < 18) {
            throw new Exception("Error: Debes ser mayor de 18 años.");
        }
    }

}