/**
 * 
 */
package com.example.petstefanini.infrastructure.entity;

/**
 * 
 */
public class TransactionResponse {
	
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		   
		return "Objeto transaccion transactionId="+this.transactionId+";dateCreated="+this.dateCreated+";status="+this.status+";name="+this.name;
	}
	private String transactionId;
	private String dateCreated;
	private String status;
	private String name;

}
