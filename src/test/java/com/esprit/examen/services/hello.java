package com.esprit.examen.services;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.ProduitRepository;

@ExtendWith(MockitoExtension.class)
public class hello {
    @Mock
    ProduitRepository produitRepository;
    @InjectMocks
    ProduitServiceImpl produitService;
    @Test
    void retrieveAllProduits() {
        Produit produit1 = new Produit(1L,"P12F2","Lait",12);
        Produit produit2 = new Produit(2L,"P12F3","Farine",18);
        List<Produit> produits = new ArrayList<>();
        produits.add(produit1);
        produits.add(produit2);
        when(produitRepository.findAll()).thenReturn(produits);
        assertEquals(2,produitService.retrieveAllProduits().size());
    }

    @Test
    void addProduit() {
        Produit produit = new Produit(1L,"P12F2","Lait",12);
        when(produitRepository.save(produit)).thenReturn(produit);
        assertEquals(produit,produitService.addProduit(produit));
    }
    @Test
    void updateProduit() {
        Produit produit = new Produit(1L,"P12F2","Lait",12);
        produit.setLibelleProduit("Farine");
        when(produitRepository.save(produit)).thenReturn(produit);
        assertEquals(produit.getLibelleProduit(),produitService.updateProduit(produit).getLibelleProduit());
    }

    @Test
    void retrieveProduit() {
        Produit produit = new Produit(1L,"P12F2","Lait",12);
        when(produitRepository.findById(1L)).thenReturn(Optional.of(produit));
        assertEquals(1L,produitService.retrieveProduit(1L).getIdProduit());
    }

    @Test
    void deleteProduit(){
        Produit produit = new Produit(1L,"P12F2","Lait",12);
        produitService.deleteProduit(produit.getIdProduit());
        verify(produitRepository, Mockito.times(1)).deleteById(produit.getIdProduit());
    }


}