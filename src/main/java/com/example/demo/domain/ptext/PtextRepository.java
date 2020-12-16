package com.example.demo.domain.ptext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PtextRepository extends JpaRepository<Ptext, Long> {

    @Query("SELECT p FROM Ptext p ORDER BY p.id DESC")
    List<Ptext> findAllDesc();


}
