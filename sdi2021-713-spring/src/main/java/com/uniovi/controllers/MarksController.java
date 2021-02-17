package com.uniovi.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uniovi.entities.Mark;
import com.uniovi.services.MarksService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MarksController {

    @Autowired // inyecta beans -> servicio
    private MarksService marksService;

    @RequestMapping("/mark/list")
    public String getList() {
	return marksService.getMarks().toString();
    }

    @RequestMapping(value = "/mark/add", method = RequestMethod.POST)
    // es una peticion POST
    public String setMark(@ModelAttribute Mark mark) {
	marksService.addMark(mark);
	return "Ok";
    }

    @RequestMapping("/mark/details/{id}")
    // es una peticion GET
    public String getDetail(@PathVariable Long id) {
	return marksService.getMark(id).toString();
    }

    @RequestMapping("/mark/delete/{id}")
    public String deleteMark(@PathVariable Long id) {
	marksService.deleteMark(id);
	return "Ok";
    }
}
