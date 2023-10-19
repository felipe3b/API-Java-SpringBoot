package com.ibanez.jem.jemguitar.repository;


import com.ibanez.jem.jemguitar.model.Guitar;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuitarRepository extends JpaRepository<Guitar, Long> {
        List<Guitar> findByNome(String nome);
        }