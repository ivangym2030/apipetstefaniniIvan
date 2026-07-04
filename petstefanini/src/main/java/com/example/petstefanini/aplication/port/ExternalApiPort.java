package com.example.petstefanini.aplication.port;

import com.example.petstefanini.domain.model.Pet;

public interface ExternalApiPort {

	public Pet findPetApi(String Id);

	public Pet savePetApiRest(Pet pet);

}
