package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.EmployeeModel;

@Repository
public interface EmployeeRepo extends CrudRepository<EmployeeModel, Integer>{

}
