package com.project.one.repository;

import com.project.one.domain.Psychologist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhysicianRepository extends JpaRepository<Psychologist,String> {
}
