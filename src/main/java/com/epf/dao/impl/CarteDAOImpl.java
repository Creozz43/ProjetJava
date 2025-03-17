package com.epf.dao.impl;

import com.epf.dao.CarteDAO;
import com.epf.model.Carte;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CarteDAOImpl implements CarteDAO {

    private final JdbcTemplate jdbcTemplate;

    public CarteDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addCarte(Carte carte) {
        String sql = "INSERT INTO cartes (chemin_image, ligne, colonne) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, carte.getCheminImage(), carte.getLigne(), carte.getColonne());
    }

    @Override
    public Carte getCarteById(int id) {
        String sql = "SELECT * FROM cartes WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new CarteRowMapper(), id);
    }

    @Override
    public List<Carte> getAllCartes() {
        String sql = "SELECT * FROM cartes";
        return jdbcTemplate.query(sql, new CarteRowMapper());
    }

    @Override
    public void updateCarte(Carte carte) {
        String sql = "UPDATE cartes SET chemin_image = ?, ligne = ?, colonne = ? WHERE id = ?";
        jdbcTemplate.update(sql, carte.getCheminImage(), carte.getLigne(), carte.getColonne(), carte.getId_map());
    }

    @Override
    public void deleteCarte(int id) {
        String sql = "DELETE FROM cartes WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public static class CarteRowMapper implements RowMapper<Carte> {
        @Override
        public Carte mapRow(ResultSet rs, int rowNum) throws SQLException {
            Carte carte = new Carte();
            carte.setId_map(rs.getInt("id"));
            carte.setCheminImage(rs.getString("chemin_image"));
            carte.setLigne(rs.getInt("ligne"));
            carte.setColonne(rs.getInt("colonne"));
            return carte;
        }
    }
}