package com.emp.controller;

import com.emp.model.ApiResponse;
import com.emp.model.Employee;
import com.emp.model.UserDto;
import com.emp.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class EmployeeController {

    @Autowired
    private EmployeeService empService;

    @PostMapping
    public ApiResponse<Employee> saveUser(@RequestBody UserDto user){
        return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.",empService.save(user));
    }

    @GetMapping
    public ApiResponse<List<Employee>> listUser(){
        return new ApiResponse<>(HttpStatus.OK.value(), "User list fetched successfully.",empService.findAll());
    }

    @GetMapping("/{id}")
    public ApiResponse<Employee> getOne(@PathVariable int id){
        return new ApiResponse<>(HttpStatus.OK.value(), "User fetched successfully.",empService.findById(id));
    }

    @PutMapping("/{id}")
    public ApiResponse<UserDto> update(@RequestBody UserDto userDto) {
        return new ApiResponse<>(HttpStatus.OK.value(), "User updated successfully.",empService.update(userDto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable int id) {
        empService.delete(id);
        return new ApiResponse<>(HttpStatus.OK.value(), "User deleted successfully.", null);
    }



}
