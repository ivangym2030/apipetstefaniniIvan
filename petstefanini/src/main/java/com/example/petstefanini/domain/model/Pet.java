package com.example.petstefanini.domain.model;

public class Pet {
	
	private String idPet;
	private String name;
	private String status;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	public String getIdPet() {
		return idPet;
	}

	public void setIdPet(String idPet) {
		this.idPet = idPet;
	}
	@Override
	public String toString() {
		   
		return "IDPET="+this.idPet+";NAME="+this.name+";STATUS="+this.status;
	}
	

}
