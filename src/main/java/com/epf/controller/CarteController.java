package com.epf.controller;

import com.epf.model.Carte;
import com.epf.service.CarteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cartes")
public class CarteController {
    private static final Logger logger = LoggerFactory.getLogger(CarteController.class);
    private final CarteService service;

    public CarteController(CarteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Carte> getAllCartes() {
        logger.info("Fetching all cartes");
        return service.getAllCartes();
    }

    @PostMapping
    public void addCarte(@RequestBody Carte carte) {
        logger.info("Adding new carte: {}", carte);
        service.addCarte(carte);
    }

    @PutMapping("/{id}")
    public void updateCarte(@PathVariable int id, @RequestBody Carte carte) {
        logger.info("Updating carte with id: {}", id);
        carte.setId_map(id);
        service.updateCarte(carte);
    }

    @DeleteMapping("/{id}")
    public void deleteCarte(@PathVariable int id) {
        logger.info("Deleting carte with id: {}", id);
        service.deleteCarte(id);
    }
}