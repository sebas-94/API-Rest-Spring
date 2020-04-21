package com.proyecto.rest.model.proj;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.proyecto.rest.model.Coche;

@Projection(name = "cocheBasico", types = Coche.class)
public interface CocheBasico {

	String getMarca();

	String getModelo();

	float getValor();

	@Value("#{target.getPiloto().getNombre()} #{target.getPiloto().getApellidos()}")
	String getPropietario();

}
