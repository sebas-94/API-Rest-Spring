package com.proyecto.rest.model.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.proyecto.rest.model.Coche;
import com.proyecto.rest.model.proj.CocheBasico;

@RepositoryRestResource(path = "coches", collectionResourceRel = "coches", excerptProjection = CocheBasico.class)
public interface CocheRepositorio extends JpaRepository<Coche, Long> {

	@RestResource(path = "marcaComienzaPor", rel = "marcaComienzaPor")
	public Page<Coche> findByMarcaStartsWith(@Param("marca") String marca, Pageable p);
	
	@RestResource(path = "modeloComienzaPor", rel = "modeloComienzaPor")
	public Page<Coche> findByModeloStartsWith(@Param("modelo") String modelo, Pageable p);
}
