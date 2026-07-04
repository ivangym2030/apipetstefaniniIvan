package com.example.petstefanini.aplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.petstefanini.aplication.port.ExternalApiPort;
import com.example.petstefanini.domain.model.Pet;
import com.example.petstefanini.infrastructure.Util.FormatUtils;
import com.example.petstefanini.infrastructure.entity.TransactionResponse;

@Service
public class PetsService {

	@Autowired
	ExternalApiPort externalApiPort;

	public Pet consultApi(String id) {
		return externalApiPort.findPetApi(id);
	}

	public TransactionResponse saveApi(Pet pet) {

		TransactionResponse trans = null;
		Pet petaux = externalApiPort.savePetApiRest(pet);
		if (petaux != null && petaux.getIdPet() != null) {

			trans = new TransactionResponse();
			trans.setTransactionId(FormatUtils.getRandomUUID());
			trans.setDateCreated(FormatUtils.getLocalTimeNow());
			trans.setStatus(pet.getStatus());
			trans.setName(pet.getName());
			System.out.println(trans.toString());
		}
		
		
		return trans;
	}
}
