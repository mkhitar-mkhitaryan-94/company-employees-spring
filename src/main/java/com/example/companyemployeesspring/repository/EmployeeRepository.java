package com.example.companyemployeesspring.repository;

import com.example.companyemployeesspring.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findAll();

    void deleteEmployeesByCompany_Id(int id);

}
