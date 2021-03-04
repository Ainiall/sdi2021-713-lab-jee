package com.uniovi.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Teacher;
import com.uniovi.repositories.TeachersRepository;


@Service // servicio
public class TeachersService {
    // el servicio se instancia una unica vez
    
    @Autowired // lista generada
    private TeachersRepository teachersRepository;

    public List<Teacher> getTeachers() {
	List<Teacher> teachersList = new ArrayList<Teacher>();
	teachersRepository.findAll().forEach(teachersList::add);
	return teachersList;
    }

    public Teacher getTeacher(Long id) {
	return teachersRepository.findById(id).get();
    }

    public void addTeacher(Teacher teacher) {
	teachersRepository.save(teacher);
    }

    public void deleteTeacher(Long id) {
	teachersRepository.deleteById(id);
    }

    public Teacher getTeacherByDNI(String dni) {
	return teachersRepository.findByDNI(dni);
    }

    public Page<Teacher> getTeachers(Pageable pageable) {
	Page<Teacher> teachersList = teachersRepository.findAll(pageable);
	return teachersList;
    }
}
