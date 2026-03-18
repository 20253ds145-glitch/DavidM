package com.example.demolistview.repositories;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

public class PersonFilesRepository {

    private final Path filetPath = Paths.get("data","persons.csv");

    private void ensureFile() throws IOException {
        if(Files.notExists(filetPath)){
            Files.createFile(filetPath);
        }
    }

    public List<String> readAllLines() throws IOException {
        ensureFile();
        return Files.readAllLines(filetPath);
    }

    public void appendNewLine(String Line) throws IOException {
        ensureFile();
        Files.writeString(filetPath,Line+System.lineSeparator(), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
    }

    public boolean delete(String personData) {
        try {
            List<String> lines = Files.readAllLines(filetPath);


            String cleanData = personData
                    .replace("Nombre: ", "")
                    .replace("Edad: ", "")
                    .replace(" | ", ",");


            boolean removed = lines.removeIf(line -> line.trim().equals(cleanData.trim()));

            if (removed) {
                Files.write(filetPath, lines);
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
