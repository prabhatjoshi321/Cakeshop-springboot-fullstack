package com.ucm.asp.veena.make_your_own_cake.model;

import java.io.InputStream;
import java.sql.Blob;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Table;




public class Cake {
	  private String cakeId;
	  public String getCakeId() {
		return cakeId;
	}
	private String cakeName;
	  private int stock;
	  private double amount;
	  private String type;
	  private InputStream imageStream;

	public InputStream getImageStream() {
		return imageStream;
	}
	public void setImageStream(InputStream imageStream) {
		this.imageStream = imageStream;
	}
	public void setCakeId(String cakeId) {
		this.cakeId = cakeId;
	}
	public String getCakeName() {
		return cakeName;
	}
	public void setCakeName(String cakeName) {
		this.cakeName = cakeName;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
