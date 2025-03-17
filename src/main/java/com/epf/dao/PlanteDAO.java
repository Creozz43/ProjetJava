package com.epf.dao;

import com.epf.model.Plante;
import java.util.List;

public interface PlanteDAO {
    void addPlante(Plante plante);
    Plante getPlanteById(int id);
    List<Plante> getAllPlantes();
    void updatePlante(Plante plante);
    void deletePlante(int id);
}