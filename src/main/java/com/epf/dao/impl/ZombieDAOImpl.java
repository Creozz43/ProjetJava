package com.epf.dao.impl;

import com.epf.dao.ZombieDAO;
import com.epf.model.Zombie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ZombieDAOImpl implements ZombieDAO {

    private final JdbcTemplate jdbcTemplate;

    public ZombieDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addZombie(Zombie zombie) {
        String sql = "INSERT INTO zombies (nom, vie, attaque_par_seconde, degat_attaque, chemin_image) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, zombie.getNom(), zombie.getPoint_de_vie(), zombie.getAttaqueParSeconde(), zombie.getDegatsParAttaque(), zombie.getCheminImage());
    }

    @Override
    public Zombie getZombieById(int id) {
        String sql = "SELECT * FROM zombies WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new ZombieRowMapper(), id);
    }

    @Override
    public List<Zombie> getAllZombies() {
        String sql = "SELECT * FROM zombies";
        return jdbcTemplate.query(sql, new ZombieRowMapper());
    }

    @Override
    public void updateZombie(Zombie zombie) {
        String sql = "UPDATE zombies SET nom = ?, vie = ?, attaque_par_seconde = ?, degat_attaque = ?, chemin_image = ? WHERE id = ?";
        jdbcTemplate.update(sql, zombie.getNom(), zombie.getPoint_de_vie(), zombie.getAttaqueParSeconde(), zombie.getDegatsParAttaque(), zombie.getCheminImage(), zombie.getId_zombie());
    }

    @Override
    public void deleteZombie(int id) {
        String sql = "DELETE FROM zombies WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Zombie> getZombiesByMapId(int mapId) {
        return List.of();
    }

    private static class ZombieRowMapper implements RowMapper<Zombie> {
        @Override
        public Zombie mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Zombie(
                    rs.getInt("id_zombie"),
                    rs.getString("nom"),
                    rs.getInt("point_de_vie"),
                    rs.getDouble("vitesse_de_deplacement"),
                    rs.getDouble("attaque_par_seconde"),
                    rs.getInt("degat_attaque"),
                    rs.getString("chemin_image"),
                    rs.getInt("map_id") // Retrieve mapId from the result set
            );
        }
    }
}