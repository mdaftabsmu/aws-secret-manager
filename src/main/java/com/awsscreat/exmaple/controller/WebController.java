package com.awsscreat.exmaple.controller;

import com.awsscreat.exmaple.EmployeeService;
import com.awsscreat.exmaple.model.Employee;
import com.awsscreat.exmaple.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class WebController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public ResponseEntity get() {
        log.info("Controller class hitting");
        return ResponseEntity.ok(employeeService.getAll());
    }

    @PostMapping("/")
    public ResponseEntity save(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeRepository.save(employee));
    }

}