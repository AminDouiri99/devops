package com.esprit.examen.services;


import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.StockRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class StockServiceTest {

	@Autowired
	StockRepository stockRepository;
    @Autowired
    StockServiceImpl stockServiceImpl;


    Stock stock = new Stock("s1",10,2) ;

    List<Stock> listStocks = new ArrayList<Stock>() {
        {
            new Stock("s2",11,3) ;
            new Stock("s3",12,4) ;
        }
    };

    @Test
    void testRetrieveAllStocks() {
        List<Stock> res  = this.stockServiceImpl.retrieveAllStocks();
        Assertions.assertEquals(0, res.size());
        verify(stockRepository).findAll();

    }

    @Test
    public void testRetrieveStock() {
        when(stockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(stock));
        Stock stock1 = stockServiceImpl.retrieveStock(Long.valueOf(1));
        assertNotNull(stock1);
        verify(stockRepository).findById((Long) any());

    }

    @Test
    void testDeleteOperateur() {
        Stock stock4 = new Stock("s4",15,5) ;
        stock4.setIdStock(4L);
        doNothing().when(stockRepository).deleteById((Long) any());
        stockServiceImpl.deleteStock(stock4.getIdStock());
        verify(stockRepository).deleteById((Long) any());
    }

}