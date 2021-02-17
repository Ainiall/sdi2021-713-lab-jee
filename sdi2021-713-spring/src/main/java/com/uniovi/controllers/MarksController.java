package com.uniovi.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uniovi.entities.Mark;
import com.uniovi.services.MarksService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@RestController // especifica una respuesta con contenido REST
@Controller // especifica una respuesta con contenido HTML
public class MarksController {

    @Autowired // inyecta beans -> servicio
    private MarksService marksService;

    @RequestMapping("/mark/list")
    public String getList(Model model) {
	model.addAttribute("markList", marksService.getMarks());
	return "mark/list";
    }

    @RequestMapping(value = "/mark/add")
    public String getMark() {
	return "mark/add";
    }

    @RequestMapping(value = "/mark/add", method = RequestMethod.POST)
    // es una peticion POST
    public String setMark(@ModelAttribute Mark mark) {
	marksService.addMark(mark);
	return "redirect:/mark/list";
    }

    @RequestMapping("/mark/details/{id}")
    // es una peticion GET
    public String getDetail(Model model, @PathVariable Long id) {
	model.addAttribute("mark", marksService.getMark(id));
	return "mark/details";
    }

    @RequestMapping("/mark/delete/{id}")
    public String deleteMark(@PathVariable Long id) {
	marksService.deleteMark(id);
	return "redirect:/mark/list";
    }

    @RequestMapping(value = "/mark/edit/{id}")
    public String getEdit(Model model, @PathVariable Long id) {
	model.addAttribute("mark", marksService.getMark(id));
	return "mark/edit";
    }

    @RequestMapping(value = "/mark/edit/{id}", method = RequestMethod.POST)
    public String setEdit(Model model, @PathVariable Long id,
	    @ModelAttribute Mark mark) {
	mark.setId(id);
	marksService.addMark(mark);
	return "redirect:/mark/details/" + id;
    }
}
