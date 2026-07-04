package com.example.petstefanini.infrastructure.adapter;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.petstefanini.aplication.port.ExternalApiPort;
import com.example.petstefanini.domain.model.Pet;
import com.example.petstefanini.infrastructure.entity.PetEntity;

@Component
public class ExternalApiAdapter implements ExternalApiPort {

	private final RestTemplate restTemplate;

	public ExternalApiAdapter(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public Pet findPetApi(String id) {
		System.out.println(id);

		return findPetApiRest(id);
	}

	public Pet findPetApiRest(String id) {

		Map<String, String> params = new HashMap<>();
		params.put("petId", id);
		String url = "https://petstore.swagger.io/v2/pet/{petId}";

		PetEntity petEntity = new PetEntity();
		;
		Pet consultPet = null;
		try {
			ResponseEntity<PetEntity> response2 = restTemplate.getForEntity(url, PetEntity.class, params);
			if (response2.getStatusCode().is2xxSuccessful()) {
				System.out.println(response2);
				petEntity = response2.getBody();
				consultPet = new Pet();
				consultPet.setIdPet(petEntity.getId());
				consultPet.setName(petEntity.getName());
				consultPet.setStatus(petEntity.getStatus());
			} else {
				petEntity = new PetEntity();
				System.out.println("PET NOT FOUND");
			}

		} catch (RestClientException e) {

			System.out.println("Excepcion");
			System.out.println(e.getMessage());
		}

		return consultPet;
	}

	public Pet savePetApiRest(Pet pet) {

		String url = "https://petstore.swagger.io/v2/pet";

		PetEntity petEntity = new PetEntity();
		;

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		
		petEntity.setId(pet.getIdPet());
		petEntity.setName(pet.getName());
		petEntity.setStatus(pet.getStatus());
		
		HttpEntity<PetEntity> requestEntity = new HttpEntity<>(petEntity, headers);

	
		try {
			ResponseEntity<PetEntity> response = restTemplate.postForEntity(url, requestEntity, PetEntity.class);
			petEntity = response.getBody();
			System.out.println("Usuario creado. Email: " + response.getBody().getId());
		} catch (RestClientException e) {
			System.err.println("Error al realizar la petición: " + e.getMessage());
		}

		pet.setIdPet(petEntity.getId());
		pet.setName(petEntity.getName());
		pet.setStatus(petEntity.getStatus());

		return pet;
	}

}
