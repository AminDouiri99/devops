package com.esprit.examen.services;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.esprit.examen.entities.Produit;
import com.esprit.examen.entities.Stock;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProduitServiceTest {

    @Autowired
    IProduitService ps;
    @Autowired
    IStockService iStockService;

    @Test
    public void testRetrieveAllUsers() {
        List<Produit> listProduits = ps.retrieveAllProduits();
        Assertions.assertEquals(0, listProduits.size());
    }
    @Test
    public void addProduit() {
        Produit produit = new Produit(1L,"P12F2","Lait",12);
        Produit produitAdded = ps.addProduit(produit);
        Assertions.assertEquals(produit.getLibelleProduit(),produitAdded.getLibelleProduit());
    }
    @Test
    void retrieveProduit() {
        Produit produit = ps.retrieveProduit(1L);
        Assertions.assertEquals(1l,produit.getIdProduit());
    }
    @Test
    void updateProduit() {
        Produit produit = ps.retrieveProduit(1L);
        produit.setLibelleProduit("Farine");
        Produit produitUpdated = ps.addProduit(produit);
        Assertions.assertEquals("Farine",produitUpdated.getLibelleProduit());
    }
    @Test
    void assignProduitToStock() {
        Stock stock= new Stock(1L,"produit laitier ", 1000, 20);
        Stock stockAdded = iStockService.addStock(stock);
        ps.assignProduitToStock(1L,1L);
        Assertions.assertEquals(stockAdded.getLibelleStock(),ps.retrieveProduit(1l).getStock().getLibelleStock());
    }
    @Test
    void deleteProduit() {
        ps.deleteProduit(1L);
        assertEquals(0,ps.retrieveAllProduits().size());
    }

}
