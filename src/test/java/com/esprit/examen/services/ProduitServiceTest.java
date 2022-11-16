package com.esprit.examen.services;

import static org.junit.Assert.assertEquals;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.entities.Stock;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProduitServiceTest {

    @Autowired
    IProduitService ps;
    @Autowired
    IStockService iStockService;

    @Test
    @Order(1)
    public void testRetrieveAllUsers() {
        List<Produit> listProduits = ps.retrieveAllProduits();
        Assertions.assertEquals(0, listProduits.size());
    }
    @Test
    @Order(2)
    public void addProduit() {
        Produit produit = new Produit(1L,"P12F2","Lait",12);
        Produit produitAdded = ps.addProduit(produit);
        Assertions.assertEquals(produit.getLibelleProduit(),produitAdded.getLibelleProduit());
    }
    @Test
    @Order(3)
    void retrieveProduit() {
        Produit produit = ps.retrieveProduit(1L);
        Assertions.assertEquals(1l,produit.getIdProduit());
    }
    @Test
    @Order(4)
    void updateProduit() {
        Produit produit = ps.retrieveProduit(1L);
        produit.setLibelleProduit("Farine");
        Produit produitUpdated = ps.addProduit(produit);
        Assertions.assertEquals("Farine",produitUpdated.getLibelleProduit());
    }
    @Test
    @Order(5)
    void assignProduitToStock() {
        Stock stock= new Stock(1L,"produit laitier ", 1000, 20, null);
        Stock stockAdded = iStockService.addStock(stock);
        ps.assignProduitToStock(1L,1L);
        Assertions.assertEquals(stockAdded.getLibelleStock(),ps.retrieveProduit(1l).getStock().getLibelleStock());
    }
    @Test
    @Order(6)
    void deleteProduit() {
        ps.deleteProduit(1L);
        assertEquals(0,ps.retrieveAllProduits().size());
    }

}