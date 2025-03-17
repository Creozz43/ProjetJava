package com.epf.service;

import com.epf.dao.CarteDAO;
import com.epf.model.Carte;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarteService {
    private final CarteDAO carteDAO;

    public CarteService(CarteDAO carteDAO) {
        this.carteDAO = carteDAO;
    }

    public List<Carte> getAllCartes() {
        return carteDAO.getAllCartes();
    }

    public void addCarte(Carte carte) {
        carteDAO.addCarte(carte);
    }

    public void updateCarte(Carte carte) {
        carteDAO.updateCarte(carte);
    }

    public void deleteCarte(int id) {
        carteDAO.deleteCarte(id);
    }
}