package com.kunal.migration_mongodb_documentdb.repository;

import com.kunal.migration_mongodb_documentdb.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, Long> {
}
