package com.emp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.emp.model.Employee;

@Repository
public interface UserDao extends CrudRepository<Employee, Integer> {

    Employee findByUsername(String username);
}
