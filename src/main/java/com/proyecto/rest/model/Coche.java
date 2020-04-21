package com.proyecto.rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
public class Coche {

	@Id @GeneratedValue
	private Long id;
	
	private String marca;
	
	private String modelo;
	
	private float valor;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "piloto_id")
	private Piloto piloto;
	
}
