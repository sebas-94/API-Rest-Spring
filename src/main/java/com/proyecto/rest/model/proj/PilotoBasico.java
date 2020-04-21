package com.proyecto.rest.model.proj;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.proyecto.rest.model.Piloto;

@Projection(name = "pilotoBasico", types = Piloto.class)
public interface PilotoBasico {

	@Value("#{target.getNombre()} #{target.getApellidos()}")
	String getNombreCompleto();
	
	String getGenero();
	
	String getNacimiento();
	
}
