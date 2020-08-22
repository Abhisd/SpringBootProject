package com.abhishek.springbootApp.web.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhishek.springbootApp.web.model.Todo;


//in JpaRepository, Integer because we have primary key int id.
public interface TodoRepository extends JpaRepository<Todo,Integer>{
	//findByUser means using name of the column.
	List<Todo> findByUser(String user);

}
