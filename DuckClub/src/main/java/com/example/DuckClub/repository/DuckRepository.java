package com.example.DuckClub.repository;

import com.example.DuckClub.entity.Duck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuckRepository extends JpaRepository<Duck, Long> {
}
