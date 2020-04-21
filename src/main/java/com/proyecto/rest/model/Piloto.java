package com.proyecto.rest.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
public class Piloto {

	@Id @GeneratedValue
	private Long id;
	
	private String nombre;
	
	private String apellidos;
	
	private String genero;
	
	private String nacimiento;
	
	@ManyToOne
	@JoinColumn(name="sponsor_id")
	private Sponsor sponsor;
	
	@EqualsAndHashCode.Exclude @ToString.Exclude
	@JsonManagedReference
	@Builder.Default
	@OneToMany(mappedBy = "piloto", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Coche> coches = new HashSet<>();
	
	@EqualsAndHashCode.Exclude @ToString.Exclude
	@JsonManagedReference
	@Builder.Default
	@OneToMany(mappedBy = "piloto", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Residencia> residencias = new HashSet<>();
	
	public int getNumCoches() {
		return (int) coches.size();
	}
	
		
	public float getValorTotalCoches() {
		return (float) coches.stream()
			.mapToDouble(Coche::getValor)
			.sum();
	}
	
	public float getValorMedioCoches() {
		return this.getValorTotalCoches() / this.getNumCoches();
	}
	
	public int getNumResidencias() {
		return (int) residencias.size();
	}
	
	/**
	 * Métodos helper
	 */
	
	public void addCoche(Coche c) {
		coches.add(c);
		c.setPiloto(this);
	}
	
	public void removeCoche(Coche c) {
		coches.remove(c);
		c.setPiloto(null);
	}
	
	public void addResidencia(Residencia r) {
		residencias.add(r);
		r.setPiloto(this);
	}
	
	public void removeResidencia(Residencia r) {
		residencias.remove(r);
		r.setPiloto(null);
	}
	
}
