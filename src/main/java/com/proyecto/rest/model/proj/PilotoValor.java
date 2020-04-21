package com.proyecto.rest.model.proj;

import org.springframework.data.rest.core.config.Projection;

import com.proyecto.rest.model.Piloto;

@Projection(name = "pilotoValor", types = Piloto.class)
public interface PilotoValor {

	String getNombre();
	
	String getApellidos();
			
	int getNumResidencias();	
	
	int getNumCoches();
	
	float getValorTotalCoches();
	
	float getValorMedioCoches();
	
}
