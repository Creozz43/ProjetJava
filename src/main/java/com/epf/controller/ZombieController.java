package com.epf.controller;

import com.epf.model.Zombie;
import com.epf.service.ZombieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zombies")
public class ZombieController {
    private final ZombieService service;

    public ZombieController(ZombieService service) {
        this.service = service;
    }

    @GetMapping
    public List<Zombie> getAllZombies() {
        return service.getAllZombies();
    }

    @PostMapping
    public void addZombie(@RequestBody Zombie zombie) {
        service.addZombie(zombie);
    }

    @PutMapping("/{id}")
    public void updateZombie(@PathVariable int id, @RequestBody Zombie zombie) {
        zombie.setId_zombie(id);
        service.updateZombie(zombie);
    }

    @DeleteMapping("/{id}")
    public void deleteZombie(@PathVariable int id) {
        service.deleteZombie(id);
    }
}