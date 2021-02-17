package com.uniovi.services;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.uniovi.entities.Mark;

@Service // servicio
public class MarksService {
    // el servicio se instancia una unica vez
    private List<Mark> marksList = new LinkedList<Mark>();

    @PostConstruct // funcion que actua como iniciador
    public void init() {
	marksList.add(new Mark(1L, "Ejercicio 1", 10.0));
	marksList.add(new Mark(2L, "Ejercicio 2", 9.0));
    }

    public List<Mark> getMarks() {
	return marksList;
    }

    public Mark getMark(Long id) {
	return marksList.stream().filter(mark -> mark.getId().equals(id))
		.findFirst().get();
    }

    public void addMark(Mark mark) {
	// si en id es null le asignamos el ultimo + 1 de la lista
	if (mark.getId() == null) {
	    mark.setId(marksList.get(marksList.size() - 1).getId() + 1);
	}
	marksList.add(mark);
    }

    public void deleteMark(Long id) {
	marksList.removeIf(mark -> mark.getId().equals(id));
    }
}