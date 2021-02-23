package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	return "redirect:/teacher/list";
    }

    @RequestMapping("/teacher/details/{id}")
    // es una peticion GET
    public String getDetail(Model model, @PathVariable Long id) {
	model.addAttribute("teacher", teachersService.getTeacher(id));
	return "teacher/details";
    }
    
    
    /*@RequestMapping("/teacher/delete/{id}")
    public String deleteTeacher(@PathVariable Long id) {
	teachersService.deleteTeacher(id);
	return "redirect:/teacher/list";
    }*/

    @RequestMapping(value = "/teacher/delete/{id}")
    public String getDelete(Model model, @PathVariable Long id) {
	model.addAttribute("teacher", teachersService.getTeacher(id));
	return "teacher/delete";
    }

    @RequestMapping(value = "/teacher/delete/{id}", method = RequestMethod.POST)
    public String setDelete(Model model, @PathVariable Long id,
	    @ModelAttribute Teacher teacher) {
	teachersService.deleteTeacher(id);
	return "redirect:/teacher/list/";
    }
    
    @RequestMapping(value = "/teacher/edit/{id}")
    public String getEdit(Model model, @PathVariable Long id) {
	model.addAttribute("teacher", teachersService.getTeacher(id));
	return "teacher/edit";
    }

    @RequestMapping(value = "/teacher/edit/{id}", method = RequestMethod.POST)
    public String setEdit( @ModelAttribute Teacher teacher) {
	Teacher t = teachersService.getTeacher(teacher.getId());
	t.setName(teacher.getName());
	t.setSurname(teacher.getSurname());
	t.setDNI(teacher.getDNI());
	t.setCategory(teacher.getCategory());
	teachersService.addTeacher(teacher);
	return "redirect:/teacher/details/" + t.getId();
    }
    
}