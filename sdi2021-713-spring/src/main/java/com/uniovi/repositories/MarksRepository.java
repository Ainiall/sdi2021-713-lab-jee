package com.uniovi.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.uniovi.entities.Mark;
import com.uniovi.entities.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

// esta clase ya es un bean al usar crud repository
public interface MarksRepository extends CrudRepository<Mark, Long> {
    @Query("SELECT r FROM Mark r WHERE (LOWER(r.description) LIKE LOWER(?1) OR LOWER(r.user.name) LIKE LOWER(?1))")
    Page<Mark> searchByDescriptionAndName(Pageable pageable, String searchtext);
    
    @Query("SELECT r FROM Mark r WHERE (LOWER(r.description) LIKE LOWER(?1) OR LOWER(r.user.name) LIKE LOWER(?1)) AND r.user = ?2")
    Page<Mark> searchByDescriptionNameAndUser(Pageable pageable, String searchtext, User user);
    
    //para que no cambie el orden al actualizar
    @Query("SELECT r FROM Mark r WHERE r.user = ?1 ORDER BY r.id ASC ")
    Page<Mark> findAllByUser(Pageable pageable, User user);
    
    Page<Mark> findAll(Pageable pageable);
    
    @Modifying
    @Transactional
    @Query("UPDATE Mark SET resend = ?1 WHERE id = ?2")
    void updateResend(Boolean resend, Long id);
}