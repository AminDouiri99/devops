package com.esprit.examen.services;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.esprit.examen.entities.Operateur;
import com.esprit.examen.entities.Produit;
package com.esprit.examen.repositories.OperateurRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class OperateurServiceImplMockTest {
    @Mock
    OperateurRepository operateurRepository;

    @InjectMocks
    OperateurServiceImpl operateurServiceImpl;

    Operateur operateur = new Operateur(1L,"df","f1", "l1");
    List<Operateur> listOperateurs = new ArrayList<Operateur>() {
        {
            add(new Operateur(2L,"s","f2", "l2"));
            add(new Operateur(3L,"b","f3", "l3"));
        }
    };

    @Test
    public void testRetrieveOperateur() {
        when(operateurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(operateur));
        Operateur operateur1 = operateurServiceImpl.retrieveOperateur(Long.valueOf(1));
        assertNotNull(operateur1);
        verify(operateurRepository).findById((Long) any());

    }


    @Test
    void testAddOperateur() {
        Operateur operateur = new Operateur();
        operateur.setIdOperateur(10L);
        operateur.setNom("op1");
        operateur.setPassword("123");
        operateur.setPrenom("pre1");
        when(operateurRepository.save(any())).thenReturn(operateur);
        assertSame(operateur, operateurServiceImpl.addOperateur(operateur));
        assertNotNull(operateur.getIdOperateur());
        verify(operateurRepository).save(any());
    }


    @Test
    void testRetrieveAllOperateurs() {
        List<Operateur> actualRetrieveAllOperateursResult = this.operateurServiceImpl.retrieveAllOperateurs();
        Assertions.assertEquals(0, actualRetrieveAllOperateursResult.size());
        verify(operateurRepository).findAll();

    }

    @Test
    void testDeleteOperateur() {
        Operateur operateur = new Operateur();
        operateur.setIdOperateur(10L);
        operateur.setNom("op1");
        operateur.setPassword("123");
        operateur.setPrenom("pre1");
        doNothing().when(operateurRepository).deleteById((Long) any());
        operateurServiceImpl.deleteOperateur(operateur.getIdOperateur());
        verify(operateurRepository).deleteById((Long) any());
    }

  //  @Test
  //  void testUpdateOperateur() {
      //  Operateur operateur = new Operateur();
       // operateur.setFactures(new HashSet<>());
        //operateur.setIdOperateur(1L);
       // operateur.setNom("Nom");
       // operateur.setPassword("1234");
       // operateur.setPrenom("Prenom");
     //   when(operateurRepository.save((Operateur) any())).thenReturn(operateur);

//        Operateur operateur1 = new Operateur();
//        operateur1.setFactures(new HashSet<>());
//        operateur1.setIdOperateur(1L);
//        operateur1.setNom("Nom");
//        operateur1.setPassword("12345");
//        operateur1.setPrenom("Prenom");
//        assertSame(operateur1, operateurServiceImpl.updateOperateur(operateur1));
//        verify(operateurRepository).save((Operateur) any());
  //  }

}
