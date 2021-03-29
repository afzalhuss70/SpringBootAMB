package com.emp.service;

import java.util.List;

import com.emp.model.Employee;
import com.emp.model.UserDto;

public interface EmployeeService {

    Employee save(UserDto user);
    List<Employee> findAll();
    void delete(int id);

    Employee findOne(String username);

    Employee findById(int id);

    UserDto update(UserDto userDto);
}
