package com.greenfoxacademy.h2project.controllers;

import com.greenfoxacademy.h2project.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/todo")
public class TodoController {

  @Autowired
  private TodoRepository todoRepository;

  @GetMapping(value={"/", "list"})
  public String list (Model model) {
    model.addAttribute("todos", todoRepository.findAll());
    return "todoslist";
  }
}
