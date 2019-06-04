package com.example.demo.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmployeeRepo;
import com.example.demo.model.EmployeeModel;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepo ER;

	@GetMapping("/getAllemp")
	public Iterable<EmployeeModel> getAll() {
		
		return ER.findAll();
	}
	
	@PostMapping("/Create")
	public EmployeeModel createemp(@RequestBody EmployeeModel EM) {
		
		return ER.save(EM);
	}
	
	@GetMapping("/getEmp/{id}")
	public Optional<EmployeeModel> getEmp(@PathVariable int id) {
		
		return ER.findById(id);
	}
	
	@PutMapping("/Update/{id}")
	
	public EmployeeModel Updateemp(@PathVariable int id, @Valid @RequestBody EmployeeModel EM) {
		
		Optional<EmployeeModel> model = ER.findById(id);
	    EmployeeModel e  = model.get();
	    e.setName(EM.getName());
		e.setAddress(EM.getAddress());
		e.setPosition(EM.getPosition());
		e.setCity(EM.getCity());
		return ER.save(e);
	}
	
	@PutMapping("/updatename/{id}")
	public EmployeeModel updatecity(@PathVariable int id, @RequestBody EmployeeModel Em ) {
		
		Optional<EmployeeModel> model = ER.findById(id);
		
		EmployeeModel E = model.get();
		E.setName(Em.getName());
		return ER.save(E);
	}
	
	@DeleteMapping("/deleteAll")
	public void DeleteAll() {
		ER.deleteAll();
	}
	
	@DeleteMapping("/delete/{id}")
	public void Deleteemp(@PathVariable int id) {
		
      ER.deleteById(id);
      
	}
}
