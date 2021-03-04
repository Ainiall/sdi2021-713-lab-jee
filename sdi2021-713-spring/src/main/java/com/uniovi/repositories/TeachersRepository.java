package com.uniovi.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.uniovi.entities.Teacher;
// esta clase ya es un bean al usar crud repository
public interface TeachersRepository extends CrudRepository<Teacher, Long> {

    Teacher findByDNI(String dni);
    
    Page<Teacher> findAll(Pageable pageable);
}