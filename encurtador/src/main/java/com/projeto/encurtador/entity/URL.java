package com.projeto.encurtador.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "url")
public class  URL {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String urloriginal;
	
	
	public URL(String urloriginal) {
		this.urloriginal = urloriginal;
	}
	
	protected URL() {
		
	}
	
	
	public int getId() {
		return id;
	}
	
	public String getUrlOriginal() {
		return urloriginal;
	}
	
	public void setUrlOriginal(String urlOriginal) {
		this.urloriginal = urlOriginal;
	}
}
