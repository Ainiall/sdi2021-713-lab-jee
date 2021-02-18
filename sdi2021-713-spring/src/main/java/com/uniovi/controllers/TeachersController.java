package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uniovi.entities.Teacher;
import com.uniovi.services.TeachersService;

@Controller
public class TeachersController {

    @Autowired // Inyectarel servicio
    private TeachersService teachersService;

    @RequestMapping("/teacher/list")
    public String getList(Model model) {
	model.addAttribute("teacherList", teachersService.getTeachers());
	return "teacher/list";
    }

    @RequestMapping(value = "/teacher/add")
    public String getTeacher() {
	return "teacher/add";
    }

    @RequestMapping(value = "/teacher/add", method = RequestMethod.POST)
    // es una peticion POST
    public String setTeacher(@ModelAttribute Teacher teacher) {
	teachersService.addTeacher(teacher);
	return "redirect:/teacher/add";
    }

    @RequestMapping("/teacher/details/{id}")
    // es una peticion GET
    public String getDetail(Model model, @PathVariable Long id) {
	model.addAttribute("teacher", teachersService.getTeacher(id));
	return "teacher/details";
    }

    @RequestMapping("/teacher/delete/{id}")
    public String deleteTeacher(@PathVariable Long id) {
	teachersService.deleteTeacher(id);
	return "redirect:/teacher/delete";
    }

    @RequestMapping(value = "/teacher/edit/{id}")
    public String getEdit(Model model, @PathVariable Long id) {
	model.addAttribute("teacher", teachersService.getTeacher(id));
	return "teacher/edit";
    }

    @RequestMapping(value = "/teacher/edit/{id}", method = RequestMethod.POST)
    public String setEdit(Model model, @PathVariable Long id,
	    @ModelAttribute Teacher teacher) {
	teacher.setId(id);
	teachersService.addTeacher(teacher);
	return "redirect:/teacher/details/" + id;
    }
}