package com.epf.model;

public class Zombie {
    private int id_zombie;
    private String nom;
    private int point_de_vie;
    private double vitesse_de_deplacement;
    private double attaque_par_seconde;
    private int degat_attaque;
    private String chemin_image;
    private int mapId; // New field

    public Zombie() {}

    public Zombie(int id, String nom, int vie, double vitesse, double attaque_par_seconde, int degat_attaque, String chemin_image, int mapId) {
        this.id_zombie = id;
        this.nom = nom;
        this.point_de_vie = vie;
        this.vitesse_de_deplacement = vitesse;
        this.attaque_par_seconde = attaque_par_seconde;
        this.degat_attaque = degat_attaque;
        this.chemin_image = chemin_image;
        this.mapId = mapId; // Initialize new field
    }

    // Getters and Setters
    public int getId_zombie() { return id_zombie; }
    public void setId_zombie(int id_zombie) { this.id_zombie = id_zombie; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public int getPoint_de_vie() { return point_de_vie; }
    public void setPoint_de_vie(int point_de_vie) { this.point_de_vie = point_de_vie; }

    public double getVitesse_de_deplacement() { return vitesse_de_deplacement; }
    public void setVitesse_de_deplacement(double vitesse_de_deplacement) { this.vitesse_de_deplacement = vitesse_de_deplacement; }

    public double getAttaqueParSeconde() { return attaque_par_seconde; }
    public void setAttaqueParSeconde(double attaque_par_seconde) { this.attaque_par_seconde = attaque_par_seconde; }

    public int getDegatsParAttaque() { return degat_attaque; }
    public void setDegatsParAttaque(int degats_par_attaque) { this.degat_attaque = degats_par_attaque; }

    public String getCheminImage() { return chemin_image; }
    public void setCheminImage(String chemin_image) { this.chemin_image = chemin_image; }

    public int getMapId() { return mapId; } // New getter
    public void setMapId(int mapId) { this.mapId = mapId; } // New setter
}