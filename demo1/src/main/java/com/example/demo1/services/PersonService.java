package com.example.demo1.services;



import com.example.demo1.repositories.PersonFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    PersonFileRepository repo = new PersonFileRepository();

    public List<String> loadForListView() throws IOException {
        List<String> lines = repo.readAllLines();
        List<String> result= new ArrayList<>();
        for(String line : lines){
            if(line==null || line.isBlank()) continue;

            String[] parts= line.split(",");
            if (parts.length < 3) continue;
            String name=parts[0].trim();
            String email=parts[1].trim();
            String age=parts[2].trim();
            result.add(name+"-"+email+"-"+age);
        }
        return result;
    }

    public void addPerson(String name, String email, String age) throws IOException {
        validate(name, email, age);
        repo.addNewLine(name+","+email+","+age);
    }
    private void validate(String name, String email, String age){
        if(name==null || name.isBlank() || name.length()<3 ){
            throw new IllegalArgumentException(" El nombre es incorrecto");
        }
        String em = (email==null) ? "" : email.trim();
        if (em.isBlank() || !em.contains("@") || !em.contains(".")){
            throw  new IllegalArgumentException(" El email es invalido");
        }


        int edad;
        try {
            edad = Integer.parseInt(age);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(" La edad debe de ser un numero");
        }
        if (edad<=0){
            throw new IllegalArgumentException(" La edad debe ser positiva");
        } else {
            if (edad<18){
                throw new IllegalArgumentException(" Tienes que ser mayor de edad para el registro");
            }
        }



    }
}
