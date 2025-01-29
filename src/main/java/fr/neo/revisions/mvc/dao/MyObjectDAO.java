package fr.neo.revisions.mvc.dao;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MyObjectDAO {

    private List<String> data = new ArrayList<>();

    public MyObjectDAO() {
        // Initialisation de la liste en dur
        data.add("Objet 1");
        data.add("Objet 2");
        data.add("Objet 3");
        data.add("Objet 4");
    }

    public List<String> findAll() {
        return data;
    }

    public String findById(int n) {
        // On utilise n modulo la taille pour gérer des indices hors bornes
        return data.get(n % data.size());
    }
}

