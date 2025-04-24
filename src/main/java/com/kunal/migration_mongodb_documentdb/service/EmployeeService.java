package com.kunal.migration_mongodb_documentdb.service;

import com.kunal.migration_mongodb_documentdb.model.Employee;
import com.kunal.migration_mongodb_documentdb.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {




    @Autowired
    private EmployeeRepository employeeRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Employee createEmployee(Employee employee) {

        try {
            employee.setPassword(passwordEncoder.encode(employee.getPassword()));

            return employeeRepository.save(employee);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public Optional<Employee> getEmployeeById(Long id) {
        try {
            return employeeRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public List<Employee> getAllEmployees() {
        try {
            return employeeRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        try {
            return employeeRepository.findById(id).map(existingEmployee -> {
                existingEmployee.setName(updatedEmployee.getName());
                existingEmployee.setEmail(updatedEmployee.getEmail());
                existingEmployee.setPassword(updatedEmployee.getPassword());
                existingEmployee.setRole(updatedEmployee.getRole());
                existingEmployee.setLastLogin(updatedEmployee.getLastLogin());
                return employeeRepository.save(existingEmployee);
            }).orElse(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void deleteEmployee(Long id) {
        try {
            employeeRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
