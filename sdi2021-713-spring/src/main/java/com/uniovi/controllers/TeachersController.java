package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uniovi.entities.Mark;
import com.uniovi.entities.Teacher;
import com.uniovi.services.TeachersService;

@RestController
public class TeachersController {

    @Autowired // Inyectarel servicio
    private TeachersService teachersService;

    @RequestMapping("/teacher/list")
    public String getList() {
	return teachersService.getTeachers().toString();
    }

    @RequestMapping(value = "/teacher/add", method = RequestMethod.POST)
    public String setTeacher(@ModelAttribute Teacher teacher) {
	teachersService.addTeacher(teacher);
	return "Added teacher";
    }

    @RequestMapping("/teacher/details/{id}")
    public String getDetail(@PathVariable Long id) {
	return "Teacher details: " + teachersService.getTeacher(id).toString();
    }

    @RequestMapping("/teacher/delete/{id}")
    public String deleteTeacher(@PathVariable Long id) {
	teachersService.deleteTeacher(id);
	return "Deleted teacher with id: " + id;
    }

    @RequestMapping(value = "/teacher/edit/{id}")
    public String getEdit(Model model, @PathVariable Long id) {
	model.addAttribute("teacher", teachersService.getTeacher(id));
	return "Edit teacher...";
    }

    @RequestMapping(value = "/teacher/edit/{id}", method = RequestMethod.POST)
    public String setEdit(Model model, @PathVariable Long id,
	    @ModelAttribute Teacher teacher) {
	teacher.setId(id);
	teachersService.addTeacher(teacher);
	return "redirect:/teacher/details/" + id;
    }
}