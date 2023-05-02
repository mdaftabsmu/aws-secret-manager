package com.awsscreat.exmaple;

import com.awsscreat.exmaple.model.Employee;
import com.awsscreat.exmaple.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;


    @Cacheable(value = "employees",cacheNames = "employees")
    public List<Employee> getAll() {
        log.info("Service class hitting");
        return employeeRepository.findAll();
    }
}
