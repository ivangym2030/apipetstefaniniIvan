package com.example.petstefanini.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.petstefanini.aplication.service.PetsService;
import com.example.petstefanini.domain.model.Pet;
import com.example.petstefanini.infrastructure.Util.FormatUtils;
import com.example.petstefanini.infrastructure.entity.ErrorResponse;
import com.example.petstefanini.infrastructure.entity.TransactionResponse;

@RestController
@RequestMapping("/api/pet")
public class ConsultsPetController {

	@Autowired
	PetsService petService;

	@PostMapping(value = "", consumes = "application/json")
	public ResponseEntity<?> saveApiPet(@RequestBody Pet pet) {

		TransactionResponse trans = null;
		ErrorResponse error = new ErrorResponse();
		ResponseEntity<?> resp = null;
		trans = petService.saveApi(pet);
		if (trans != null) {
			resp = ResponseEntity.ok(trans);
		} else {
			error = FormatUtils.getError("1", "Error in save", "error");
			resp = ResponseEntity.ok(error);
		}
		return resp;
	}

	@GetMapping("")
	public ResponseEntity<?> consultbyId(@RequestParam("idPet") String idPet) {

		Pet pet = null;
		ErrorResponse error = new ErrorResponse();
		ResponseEntity<?> resp = null;

		pet = petService.consultApi(idPet);
		if (pet != null) {
			resp = ResponseEntity.ok(pet);
		} else {
			error = FormatUtils.getError("1", "PET NOT FOUBD", "Error");
			resp = ResponseEntity.ok(error);
		}

		return resp;
	}

}
