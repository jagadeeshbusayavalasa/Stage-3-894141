package com.cognizant.LearnTodayRESTAPI.controller;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.LearnTodayRESTAPI.dao.TrainerDao;
import com.cognizant.LearnTodayRESTAPI.dao.exception.InvalidTrainerIdException;
import com.cognizant.LearnTodayRESTAPI.dao.impl.TrainerDaoImpl;
import com.cognizant.LearnTodayRESTAPI.model.Trainer;

@RestController
@RequestMapping("/api/trainer")
public class TrainerController {
	TrainerDao dao;
	
	public TrainerController(TrainerDao dao) {
		super();
		this.dao = dao;
	}

	@PostMapping(value="/trainerSignUp",produces = {APPLICATION_JSON_VALUE,APPLICATION_XML_VALUE},
			consumes = {APPLICATION_JSON_VALUE,APPLICATION_XML_VALUE})
	public ResponseEntity<Object> trainerSignUp(@RequestBody Trainer trainer){

		try {
			dao.signUp(trainer);
			return new ResponseEntity<>(trainer, HttpStatus.CREATED);
		} catch (DuplicateKeyException e) {
			return new ResponseEntity<>("Bad request", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping(value="/updatePassword",consumes = {APPLICATION_JSON_VALUE,APPLICATION_XML_VALUE})
	public ResponseEntity<Object> updatePassword( @RequestBody Trainer trainer) throws InvalidTrainerIdException {
		
			
				int i=dao.updatePassWord(trainer.getTrainerId(), trainer);
				if(i>0)
				return new ResponseEntity<>("Data updated successfully", HttpStatus.OK);
			return null;
	}
}
