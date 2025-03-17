package com.epf.dao;

import com.epf.model.Zombie;
import java.util.List;

public interface ZombieDAO {
    void addZombie(Zombie zombie);
    Zombie getZombieById(int id);
    List<Zombie> getAllZombies();
    void updateZombie(Zombie zombie);
    void deleteZombie(int id);
    List<Zombie> getZombiesByMapId(int mapId);
}