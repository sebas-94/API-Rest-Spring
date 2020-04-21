package com.proyecto.rest.model.proj;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.proyecto.rest.model.Piloto;

@Projection(name = "pilotoSponsor", types = Piloto.class)
public interface PilotoSponsor {

	String getNombre();
	
	String getApellidos();
	
	@Value("#{target.getSponsor().getNombre()}")
	String getSponsor();
	
}
