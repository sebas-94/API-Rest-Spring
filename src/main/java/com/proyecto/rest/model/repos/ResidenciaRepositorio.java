package com.proyecto.rest.model.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.proyecto.rest.model.Residencia;
import com.proyecto.rest.model.proj.ResidenciaBasico;


@RepositoryRestResource(path = "residencias", collectionResourceRel = "residencias",excerptProjection = ResidenciaBasico.class)
public interface ResidenciaRepositorio extends JpaRepository<Residencia, Long>{
	
	@RestResource(path = "paisComienzaPor", rel = "paisComienzaPor")
	public Page<Residencia> findByPaisStartsWith(@Param("pais") String pais, Pageable p);
	
	@RestResource(path = "ciudadComienzaPor", rel = "ciudadComienzaPor")
	public Page<Residencia> findByCiudadStartsWith(@Param("ciudad") String ciudad, Pageable p);
	
	@RestResource(path = "calleComienzaPor", rel = "calleComienzaPor")
	public Page<Residencia> findByCalleStartsWith(@Param("calle") String calle, Pageable p);
}
