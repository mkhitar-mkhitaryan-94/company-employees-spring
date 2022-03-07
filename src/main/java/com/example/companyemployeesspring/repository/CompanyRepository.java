package com.example.companyemployeesspring.repository;

import com.example.companyemployeesspring.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company,Integer> {
    List<Company> findAll();
}
