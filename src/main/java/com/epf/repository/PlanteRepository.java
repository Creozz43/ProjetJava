package com.epf.repository;

import com.epf.model.Plante;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlanteRepository {
    private final JdbcTemplate jdbcTemplate;

    public PlanteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Récupérer toutes les plantes
    public List<Plante> getAll() {
        return jdbcTemplate.query("SELECT * FROM plante", (rs, rowNum) ->
                new Plante(
                        rs.getInt("id_plante"),
                        rs.getString("nom"),
                        rs.getInt("point_de_vie"),
                        rs.getDouble("attaque_par_seconde"),
                        rs.getInt("degat_attaque"),
                        rs.getInt("cout"),
                        rs.getDouble("soleil_par_seconde"),
                        rs.getString("effet"),
                        rs.getString("chemin_image")
                )
        );
    }

    // Ajouter une plante
    public int add(Plante plante) {
        return jdbcTemplate.update("INSERT INTO plante (nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                plante.getNom(), plante.getPoint_de_vie(), plante.getAttaque_par_seconde(),
                plante.getDegat_attaque(), plante.getCout(), plante.getSoleil_par_seconde(),
                plante.getEffet(), plante.getChemin_image());
    }

    // Modifier une plante
    public int update(Plante plante) {
        return jdbcTemplate.update("UPDATE plante SET nom=?, point_de_vie=?, attaque_par_seconde=?, degat_attaque=?, cout=?, soleil_par_seconde=?, effet=?, chemin_image=? WHERE id_plante=?",
                plante.getNom(), plante.getPoint_de_vie(), plante.getAttaque_par_seconde(),
                plante.getDegat_attaque(), plante.getCout(), plante.getSoleil_par_seconde(),
                plante.getEffet(), plante.getChemin_image(), plante.getId_plante());
    }

    // Supprimer une plante
    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM plante WHERE id_plante=?", id);
    }
}
