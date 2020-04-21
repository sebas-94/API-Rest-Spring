package com.proyecto.rest.model.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.proyecto.rest.model.Sponsor;

@RepositoryRestResource(path = "sponsors", collectionResourceRel = "sponsors")
public interface SponsorRepositorio extends JpaRepository<Sponsor, Long> {

	@RestResource(path = "nombreComienzaPor", rel = "nombreComienzaPor")
	public Page<Sponsor> findByNombreStartsWith(@Param("nombre") String nombre, Pageable p);

}
