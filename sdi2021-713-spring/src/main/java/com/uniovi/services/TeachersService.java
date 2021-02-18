package com.uniovi.services;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import com.uniovi.entities.Teacher;


@Service // servicio
public class TeachersService {
    // el servicio se instancia una unica vez
    private List<Teacher> teachersList = new LinkedList<Teacher>();

    @PostConstruct
    public void init() {
	// lista de profesores por defecto en memoria
	teachersList
		.add(new Teacher(1L, "99999999Z", "John", "Doe", "Science"));
	teachersList
		.add(new Teacher(2L, "00000000A", "Jane", "Doe", "English"));
	teachersList
		.add(new Teacher(3L, "11111111B", "Sam", "Smith", "Biology"));
	teachersList
		.add(new Teacher(4L, "22222222C", "Juan", "Castillo", "Spanish"));
    }

    public List<Teacher> getTeachers() {
	return teachersList;
    }

    public Teacher getTeacher(Long id) {
	return teachersList.stream().filter(t -> t.getId().equals(id))
		.findFirst().get();
    }

    public void addTeacher(Teacher teacher) {
	// si en id es null le asignamos el ultimo + 1 de la lista
	if (teacher.getId() == null) {
	    teacher.setId(
		    teachersList.get(teachersList.size() - 1).getId() + 1);
	}
    }

    public void deleteTeacher(Long id) {
	teachersList.removeIf(t -> t.getId().equals(id));
    }
}
