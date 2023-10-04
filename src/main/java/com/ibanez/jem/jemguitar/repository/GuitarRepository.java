package com.ibanez.jem.jemguitar.repository;


import com.ibanez.jem.jemguitar.model.Guitar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuitarRepository extends JpaRepository<Guitar, Long> {
}