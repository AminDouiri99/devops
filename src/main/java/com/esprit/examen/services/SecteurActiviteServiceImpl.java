package com.esprit.examen.services;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.repositories.SecteurActiviteRepository;

@Service
@Slf4j
public class SecteurActiviteServiceImpl implements ISecteurActiviteService{

	@Autowired
	SecteurActiviteRepository secteurActiviteRepository;
	@Override
	public List<SecteurActivite> retrieveAllSecteurActivite() {
		log.info("In method retrieveAllSecteurActivite");
		log.info("out of method retrieveAllSecteurActivite");

		return (List<SecteurActivite>) secteurActiviteRepository.findAll();
	}

	@Override
	public SecteurActivite addSecteurActivite(SecteurActivite sa) {
		log.info("In method retrieveAllSecteurActivite");

		secteurActiviteRepository.save(sa);
		log.info("out of method retrieveAllSecteurActivite");

		return sa;
	}

	@Override
	public void deleteSecteurActivite(Long id) {
		log.info("In method retrieveAllSecteurActivite");

		secteurActiviteRepository.deleteById(id);
		log.info("out of method retrieveAllSecteurActivite");

	}

	@Override
	public SecteurActivite updateSecteurActivite(SecteurActivite sa) {
		log.info("In method retrieveSecteurActivite");

		secteurActiviteRepository.save(sa);
		log.info("out of method retrieveSecteurActivite");

		return sa;
	}

	@Override
	public SecteurActivite retrieveSecteurActivite(Long id) {
		log.info("In method retrieveSecteurActivite");

		SecteurActivite secteurActivite = secteurActiviteRepository.findById(id).orElse(null);
		log.info("out of method retrieveAllSecteurActivite");

		return secteurActivite;
	}

}
