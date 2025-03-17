package com.epf.test;

import com.epf.model.Carte;
import com.epf.dao.CarteDAO;
import com.epf.service.CarteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CarteServiceTest {

    @Mock
    private CarteDAO carteDAO;

    @InjectMocks
    private CarteService carteService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllCartes() {
        List<Carte> cartes = List.of(new Carte());
        when(carteDAO.getAllCartes()).thenReturn(cartes);

        List<Carte> result = carteService.getAllCartes();

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    public void testAddCarte() {
        Carte carte = new Carte();
        doNothing().when(carteDAO).addCarte(carte);

        carteService.addCarte(carte);

        verify(carteDAO, times(1)).addCarte(carte);
    }

    @Test
    public void testUpdateCarte() {
        Carte carte = new Carte();
        doNothing().when(carteDAO).updateCarte(carte);

        carteService.updateCarte(carte);

        verify(carteDAO, times(1)).updateCarte(carte);
    }

    @Test
    public void testDeleteCarte() {
        int id = 1;
        doNothing().when(carteDAO).deleteCarte(id);

        carteService.deleteCarte(id);

        verify(carteDAO, times(1)).deleteCarte(id);
    }
}