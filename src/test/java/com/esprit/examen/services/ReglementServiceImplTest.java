package com.esprit.examen.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Reglement;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest

public class ReglementServiceImplTest {
	@Autowired
	IReglementService reglementService;
	
	 @Test
	    public void testAddReglement() throws ParseException{
		 SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date dateReglement = dateFormat.parse("30/09/2000");
	        //Adding an regulation to the DB
	        Reglement op = new Reglement(8, 10, false, dateReglement);
	        Reglement savedOp = this.reglementService.addReglement(op);
	        /*Make sure the operator exist created exist in the db and
	        * have the same values
	        * */
	        assertNotNull(savedOp.getIdReglement());
	        assertSame(8,savedOp.getMontantPaye());
	        assertSame(10,savedOp.getMontantRestant());
	        assertSame(false,savedOp.getPayee());
	        assertSame(dateReglement,savedOp.getDateReglement());
	        //Deleting the test reglement
	        this.reglementService.deleteReglement(savedOp.getIdReglement());
	    }
	
	 @Test
	    public void testRetrieveReglement() throws ParseException{
		 SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date dateReglement = dateFormat.parse("30/09/2000");
	        //Adding an operator to the DB
	        Reglement op = new Reglement(8, 10, false,dateReglement);
	        Reglement savedOp = this.reglementService.addReglement(op);
	        //Make sure that the retrieve get the same value of the added operator

	        assertEquals(savedOp.getMontantPaye(),this.reglementService.retrieveReglement(savedOp.getIdReglement()).getMontantPaye());
	        assertEquals(op.getMontantRestant(),this.reglementService.retrieveReglement(savedOp.getIdReglement()).getMontantRestant());
	        assertEquals(op.getPayee(),this.reglementService.retrieveReglement(savedOp.getIdReglement()).getPayee());
	        assertEquals(op.getDateReglement(),this.reglementService.retrieveReglement(savedOp.getIdReglement()).getDateReglement());

	        //Deleting the operator from the DB
	        this.reglementService.deleteReglement(savedOp.getIdReglement());
	        
	    }
}
