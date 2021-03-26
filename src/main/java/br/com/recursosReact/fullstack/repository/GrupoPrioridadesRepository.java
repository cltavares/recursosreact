package br.com.recursosReact.fullstack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.recursosReact.fullstack.domain.GrupoPrioridades;

@Repository
public interface GrupoPrioridadesRepository extends JpaRepository<GrupoPrioridades, Long> {

}
