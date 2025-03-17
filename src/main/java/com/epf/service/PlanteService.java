package com.epf.service;

import com.epf.dao.PlanteDAO;
import com.epf.model.Plante;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanteService {
    private final PlanteDAO planteDAO;

    public PlanteService(PlanteDAO planteDAO) {
        this.planteDAO = planteDAO;
    }

    public List<Plante> getAllPlantes() {
        return planteDAO.getAllPlantes();
    }

    public void addPlante(Plante plante) {
        planteDAO.addPlante(plante);
    }

    public void updatePlante(Plante plante) {
        planteDAO.updatePlante(plante);
    }

    public void deletePlante(int id) {
        planteDAO.deletePlante(id);
    }
}