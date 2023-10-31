package com.ibanez.jem.jemguitar.repository;

import com.ibanez.jem.jemguitar.model.Guitar;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuitarRepository extends JpaRepository<Guitar, UUID> {
        List<Guitar> findByNome(String nome);
}