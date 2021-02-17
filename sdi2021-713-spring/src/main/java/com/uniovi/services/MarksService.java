package com.uniovi.services;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Mark;
import com.uniovi.repositories.MarksRepository;

@Service // servicio
public class MarksService {
    // el servicio se instancia una unica vez
    @Autowired
    private MarksRepository marksRepository;
    
    /* Ya no se usa una lista en memoria
     * @PostConstruct // funcion que actua como iniciador public void init() {
     * marksList.add(new Mark(1L, "Ejercicio 1", 10.0)); marksList.add(new
     * Mark(2L, "Ejercicio 2", 9.0)); }
     */

    public List<Mark> getMarks() {
	List<Mark> marks = new ArrayList<Mark>();
	marksRepository.findAll().forEach(marks::add);
	return marks;
    }

    public Mark getMark(Long id) {
	return marksRepository.findById(id).get();
    }

    public void addMark(Mark mark) {
	// si en id es null le asignamos el ultimo + 1 de la lista
	marksRepository.save(mark);
    }

    public void deleteMark(Long id) {
	marksRepository.deleteById(id);
    }
}