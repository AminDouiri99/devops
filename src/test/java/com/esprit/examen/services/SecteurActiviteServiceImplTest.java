package com.esprit.examen.services;

import com.esprit.examen.entities.SecteurActivite;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecteurActiviteServiceImplTest {
    @Autowired
    ISecteurActiviteService secteurActiviteService;
    @Test
    public void addSecteurActiviteTest(){
        //Adding an secteurActivite to the DB
        SecteurActivite secteurActivite = new SecteurActivite("test code","libelle test");
        SecteurActivite savedsecteurActivite = this.secteurActiviteService.addSecteurActivite(secteurActivite);
        /*Make sure the secteurActivite exist created exist in the db and
         * have the same values
         * */
        assertNotNull(savedsecteurActivite.getIdSecteurActivite());
        assertSame("test code",savedsecteurActivite.getCodeSecteurActivite());
        assertSame("libelle test",savedsecteurActivite.getLibelleSecteurActivite());
        //Deleting the test operator
        this.secteurActiviteService.deleteSecteurActivite(savedsecteurActivite.getIdSecteurActivite());
    }
    @Test
    public void deleteSecteurActiviteTest(){
        //Adding an deleteSecteurActiviteTest to the DB

    }
}
