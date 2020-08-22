package com.abhishek.springbootApp.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.abhishek.springbootApp.web.model.Todo;
import com.abhishek.springbootApp.web.service.TodoRepository;
import com.abhishek.springbootApp.web.service.TodoService;

//@Controller picks up methods from the class as request mapping.

@Controller
@SessionAttributes("name")
public class TodoController {
	
	
	@Autowired
	TodoRepository repository;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		//Date Pattern=>dd/mm/yyyy
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat,false));
	}
	
	
	@RequestMapping(value="/list-todos",method=RequestMethod.GET)
	public String showTodos(ModelMap model) {
		String name=getLoggedInUserName(model);
		model.put("todos",repository.findByUser(name));
	//model.put("todos",service.retrieveTodos(name));
		return "list-todos";
	}


	private String getLoggedInUserName(ModelMap model) {
		return (String)model.get("name");
	}
	
	
	@RequestMapping(value="/add-todo",method=RequestMethod.GET)
	public String showAddPlayerPage	(ModelMap model) {
		model.addAttribute("todo",new Todo(0,getLoggedInUserName(model),"", new Date(),false));
		return "todo";
	}
	
	
	@RequestMapping(value="/add-todo",method=RequestMethod.POST)
	public String addTodos(ModelMap model,@Valid Todo todo,BindingResult result) {
		//@size validation from todo class is controlled here so we adding @Valid to object of Todo.
		if(result.hasErrors()) {
			return "todo";
		}
		todo.setUser(getLoggedInUserName(model));
		repository.save(todo);
		//service.addTodo(getLoggedInUserName(model), todo.getDesc(), todo.getTargetDate(),false);
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value="/delete-todo",method=RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		repository.delete(id);
		//service.deleteTodo(id);
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value="/update-todo",method=RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id,ModelMap model) {
		Todo todo=repository.findOne(id);
		//Todo todo=service.retrieveTodo(id);
		model.put("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="/update-todo",method=RequestMethod.POST)
	public String updateTodo(ModelMap model,@Valid Todo todo,BindingResult result) {
		
		todo.setUser(getLoggedInUserName(model));
		if(result.hasErrors()) {
			return "todo";
		}
		repository.save(todo);
	//	service.updateTodo(todo);
		
		return "redirect:/list-todos";
	}
	
	
}























