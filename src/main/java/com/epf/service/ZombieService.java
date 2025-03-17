package com.epf.service;

import com.epf.model.Zombie;
import com.epf.dao.ZombieDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZombieService {
    private final ZombieDAO zombieDAO;

    public ZombieService(ZombieDAO zombieDAO) {
        this.zombieDAO = zombieDAO;
    }

    public List<Zombie> getAllZombies() {
        return zombieDAO.getAllZombies();
    }

    public void addZombie(Zombie zombie) {
        zombieDAO.addZombie(zombie);
    }

    public void updateZombie(Zombie zombie) {
        zombieDAO.updateZombie(zombie);
    }

    public void deleteZombie(int id) {
        zombieDAO.deleteZombie(id);
    }
    public List<Zombie> getZombiesByMapId(int mapId) {
        return zombieDAO.getZombiesByMapId(mapId);
    }
}