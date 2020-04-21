package com.proyecto.rest.model.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.proyecto.rest.model.Piloto;
import com.proyecto.rest.model.proj.PilotoBasico;


@RepositoryRestResource(path = "pilotos", collectionResourceRel = "pilotos" ,excerptProjection = PilotoBasico.class)
public interface PilotoRepositorio extends JpaRepository<Piloto, Long>{
	
	@RestResource(path = "nombreComienzaPor", rel = "nombreComienzaPor")
	public Page<Piloto> findByNombreStartsWith(@Param("nombre") String nombre, Pageable p);
	
	@RestResource(path = "apellidosComienzaPor", rel = "apellidosComienzaPor")
	public Page<Piloto> findByApellidosStartsWith(@Param("apellidos") String apellidos, Pageable p);
	
}
