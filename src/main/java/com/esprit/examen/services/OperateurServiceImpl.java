package com.esprit.examen.services;

import java.util.List;

import com.esprit.examen.entities.Stock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esprit.examen.entities.Operateur;
import com.esprit.examen.repositories.OperateurRepository;


@Slf4j
@Service
public class OperateurServiceImpl implements IOperateurService {

	@Autowired
	OperateurRepository  operateurRepository;
	@Override
	public List<Operateur> retrieveAllOperateurs() {
		log.info("In method retrieveAllOperateurs");
		List<Operateur> Ops = (List<Operateur>) operateurRepository.findAll();
		for (Operateur operateur : Ops) {
			log.info(" Operateur : " + operateur);
		}
		log.info("out of method retrieveAllOperateurs");
		return Ops;
	}

	@Override
	public Operateur addOperateur(Operateur o) {
		log.info("In method addOperateur");
		log.info("You have added the operator :"+o);

		operateurRepository.save(o);
		log.info("out of method addOperateur");

		return o;
	}

	@Override
	public void deleteOperateur(Long id) {
		log.info("In method deleteOperateur");
		log.info("You want to delete the operator with the id :"+id);
		log.info("out of method deleteOperateur");

		operateurRepository.deleteById(id);
		
	}

	@Override
	public Operateur updateOperateur(Operateur o) {
		log.info("In method updateOperateur");
		log.info("You want to update the operator :"+o);
		log.info("out of method updateOperateur");

		operateurRepository.save(o);
		return o;
	}

	@Override
	public Operateur retrieveOperateur(Long id) {
		log.info("In method retrieveOperateur");
		log.info("You want to retrieve the operator with the id : "+id);
		log.info("out of method retrieveOperateur");

		Operateur operateur = operateurRepository.findById(id).orElse(null);
		return operateur;
	}

}
