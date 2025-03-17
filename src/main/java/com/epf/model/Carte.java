package com.epf.model;

public class Carte {
    private int id_map;
    private String chemin_image;
    private int ligne;
    private int colonne;

    public Carte() {}

    public Carte(int id, String chemin_image, int ligne, int colonne) {
        this.id_map = id;
        this.chemin_image = chemin_image;
        this.ligne = ligne;
        this.colonne = colonne;
    }

    // Getters et Setters
    public int getId_map() { return id_map; }
    public void setId_map(int id_map) { this.id_map = id_map; }

    public String getCheminImage() { return chemin_image; }
    public void setCheminImage(String chemin_image) { this.chemin_image = chemin_image; }

    public int getLigne() { return ligne; }
    public void setLigne(int ligne) { this.ligne = ligne; }

    public int getColonne() { return colonne; }
    public void setColonne(int colonne) { this.colonne = colonne; }
}