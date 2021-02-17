package com.uniovi.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uniovi.entities.Mark;

import org.springframework.web.bind.annotation.*;

@RestController
public class MarksController {

    @RequestMapping("/mark/list")
    public String getList() {
	return "Getting List";
    }

    @RequestMapping(value = "/mark/add", method = RequestMethod.POST)
    // es una peticion POST
    public String setMark(@ModelAttribute Mark mark) {
	return "added: " + mark.getDescription() + " with score : "
		+ mark.getScore() + " id: " + mark.getId();
    }

    @RequestMapping("/mark/details/{id}")
    // es una peticion GET
    public String getDetail(@PathVariable Long id) {
	return "Getting Detail: " + id;
    }
}
