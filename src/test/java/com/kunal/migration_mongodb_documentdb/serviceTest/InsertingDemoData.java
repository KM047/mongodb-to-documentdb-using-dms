package com.kunal.migration_mongodb_documentdb.serviceTest;

import com.kunal.migration_mongodb_documentdb.model.Employee;
import com.kunal.migration_mongodb_documentdb.model.Preferences;
import com.kunal.migration_mongodb_documentdb.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class InsertingDemoData {

    @Autowired
    private EmployeeService employeeService;

    @Test
    void creatingDemoData() {

        String[] roles = {"DEVELOPER", "MANAGER", "SUPPORT", "TESTER", "CEO"};
        for (int i = 1001; i <= 2000; i++) {

            Employee employee = new Employee();
            employee.setId((long) i);
            employee.setName("Employee " + i);
            employee.setEmail("employee" + i + "@example.com");
            employee.setPassword("password" + i);
            employee.setRole(roles[i % roles.length]);
            employee.setLastLogin(Instant.now());
            Preferences prefs = new Preferences();
            prefs.setLanguage("en");
            prefs.setNotifications(true);
            employee.setPreferences(prefs);

            assertNotNull(employeeService.createEmployee(employee));
        }

        log.info("Demo Data Inserted");


    }

}
