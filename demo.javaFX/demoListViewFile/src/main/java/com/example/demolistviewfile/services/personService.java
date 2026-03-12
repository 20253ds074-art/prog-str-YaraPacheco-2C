package com.example.demolistviewfile.services;

import java.util.ArrayList;

public class personService {
    PersonFileRepository repo =new PersonFileRepository();
    public List<String> loadForListView{
        List<String> lines=repo.readAllines();
        List<String> result=new ArrayList<>();
        if (String: line : lines){
            if (line==null || line.isBlank()) continue;
            String[] parts= line.split(",");
            String name=parts

            }
        }
    }
}
