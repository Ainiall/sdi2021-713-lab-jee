package com.uniovi.repositories;

import org.springframework.data.repository.CrudRepository;

import com.uniovi.entities.Mark;
// esta clase ya es un bean al usar crud repository
public interface MarksRepository extends CrudRepository<Mark, Long> {
}