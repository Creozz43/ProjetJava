package com.epf.controller;

import com.epf.model.Plante;
import com.epf.service.PlanteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plantes")
public class PlanteController {
    private final PlanteService service;

    public PlanteController(PlanteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Plante> getAllPlantes() {
        return service.getAllPlantes();
    }

    @PostMapping
    public void addPlante(@RequestBody Plante plante) {
        service.addPlante(plante);
    }

    @PutMapping("/{id}")
    public void updatePlante(@PathVariable int id, @RequestBody Plante plante) {
        plante.setId_plante(id);
        service.updatePlante(plante);
    }

    @DeleteMapping("/{id}")
    public void deletePlante(@PathVariable int id) {
        service.deletePlante(id);
    }
}