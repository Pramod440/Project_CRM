package com.crm.repository;

import com.crm.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
//JpaRepository supports pagination and sorting.
//CrudRepository does not support for pagination and sorting.