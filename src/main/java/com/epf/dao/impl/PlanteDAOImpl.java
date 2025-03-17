package com.epf.dao.impl;

import com.epf.dao.PlanteDAO;
import com.epf.model.Plante;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PlanteDAOImpl implements PlanteDAO {

    private final JdbcTemplate jdbcTemplate;

    public PlanteDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addPlante(Plante plante) {
        String sql = "INSERT INTO plantes (nom, vie, attaque_par_seconde, degat_attaque, chemin_image) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, plante.getNom(), plante.getPoint_de_vie(), plante.getAttaque_par_seconde(), plante.getDegat_attaque(), plante.getChemin_image());
    }

    @Override
    public Plante getPlanteById(int id) {
        String sql = "SELECT * FROM plantes WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new PlanteRowMapper(), id);
    }

    @Override
    public List<Plante> getAllPlantes() {
        String sql = "SELECT * FROM plantes";
        return jdbcTemplate.query(sql, new PlanteRowMapper());
    }

    @Override
    public void updatePlante(Plante plante) {
        String sql = "UPDATE plantes SET nom = ?, vie = ?, attaque_par_seconde = ?, degat_attaque = ?, chemin_image = ? WHERE id = ?";
        jdbcTemplate.update(sql, plante.getNom(), plante.getPoint_de_vie(), plante.getAttaque_par_seconde(), plante.getDegat_attaque(), plante.getChemin_image(), plante.getId_plante());
    }

    @Override
    public void deletePlante(int id) {
        String sql = "DELETE FROM plantes WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    private static class PlanteRowMapper implements RowMapper<Plante> {
        @Override
        public Plante mapRow(ResultSet rs, int rowNum) throws SQLException {
            Plante plante = new Plante();
            plante.setId_plante(rs.getInt("id_plante"));
            plante.setNom(rs.getString("nom"));
            plante.setPoint_de_vie(rs.getInt("point_de_vie"));
            plante.setAttaque_par_seconde(rs.getDouble("attaque_par_seconde"));
            plante.setDegat_attaque(rs.getInt("degat_attaque"));
            plante.setChemin_image(rs.getString("chemin_image"));
            return plante;
        }
    }
}