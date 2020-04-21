package com.proyecto.rest.model.proj;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.proyecto.rest.model.Residencia;;

@Projection(name = "residenciaBasico", types = Residencia.class)
public interface ResidenciaBasico {

	String getPais();

	String getCiudad();

	String getCalle();

	Long getNumero();
	
	@Value("#{target.getPiloto().getNombre()} #{target.getPiloto().getApellidos()}")
	String getPropietario();

}
