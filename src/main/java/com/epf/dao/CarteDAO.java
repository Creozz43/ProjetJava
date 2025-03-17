package com.epf.dao;

import com.epf.model.Carte;
import java.util.List;

public interface CarteDAO {
    void addCarte(Carte carte);
    Carte getCarteById(int id);
    List<Carte> getAllCartes();
    void updateCarte(Carte carte);
    void deleteCarte(int id);
}