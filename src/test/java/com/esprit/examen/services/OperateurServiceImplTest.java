package com.esprit.examen.services;

import com.esprit.examen.entities.Operateur;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OperateurServiceImplTest {
    @Autowired
    IOperateurService operateurService;
    @Test
    public void testAddOperateur(){
        //Adding an operateur to the DB
        Operateur op = new Operateur("test nom","prénom test","passwordtest");
        Operateur savedOp = this.operateurService.addOperateur(op);
        /*Make sure the operator exist created exist in the db and
        * have the same values
        * */
        assertNotNull(savedOp.getIdOperateur());
        assertSame("test nom",savedOp.getNom());
        assertSame("prénom test",savedOp.getPrenom());
        assertSame("passwordtest",savedOp.getPassword());
        //Deleting the test operator
        this.operateurService.deleteOperateur(savedOp.getIdOperateur());
    }
    @Test
    public void testDeleteOperateur(){
        //Adding an operateur to the DB
        Operateur op = new Operateur("test nom","prénom test","passwordtest");
        Operateur savedOp = this.operateurService.addOperateur(op);
        //Deleting the operator from the DB
        this.operateurService.deleteOperateur(savedOp.getIdOperateur());
        //Make sure the operator does not exist anymore in the DB
        assertNull(this.operateurService.retrieveOperateur(savedOp.getIdOperateur()));

    }
    @Test
    public void testUpdateOperateur() {
        //Adding an operator to the DB
        Operateur op = new Operateur("test nom","prénom test","passwordtest");
        Operateur savedOp = this.operateurService.addOperateur(op);
        //Stocking the old version of the operator before the update
        Operateur OldOp = this.operateurService.retrieveOperateur(savedOp.getIdOperateur());
        //Updating the values of the operator
        savedOp.setNom("new test nom");
        savedOp.setPrenom("new prénom test");
        savedOp.setPassword("new passwordtest");
        this.operateurService.updateOperateur(savedOp);
        //Making sure that the operator values has been changed to the new values
        assertNotSame(OldOp,savedOp);
        assertSame("new test nom",savedOp.getNom());
        assertSame("new prénom test",savedOp.getPrenom());
        assertSame("new passwordtest",savedOp.getPassword());

        //Deleting the operator from the DB
        this.operateurService.deleteOperateur(savedOp.getIdOperateur());
    }
    @Test
    public void testRetrieveOperateur(){
        //Adding an operator to the DB
        Operateur op = new Operateur("test nom","prénom","passwordtest");
        Operateur savedOp = this.operateurService.addOperateur(op);
        //Make sure that the retrieve get the same value of the added operator

        assertEquals(savedOp.getNom(),this.operateurService.retrieveOperateur(savedOp.getIdOperateur()).getNom());
        assertEquals(op.getPrenom(),this.operateurService.retrieveOperateur(savedOp.getIdOperateur()).getPrenom());
        assertEquals(op.getPassword(),this.operateurService.retrieveOperateur(savedOp.getIdOperateur()).getPassword());

        //Deleting the operator from the DB
        this.operateurService.deleteOperateur(savedOp.getIdOperateur());

    }

}
