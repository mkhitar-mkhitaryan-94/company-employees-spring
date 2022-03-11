package com.example.companyemployeesspring.service;


import com.example.companyemployeesspring.entity.Company;
import com.example.companyemployeesspring.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public void save(Company company) {
        companyRepository.save(company);
    }

    public void deleteById(int id) {
        companyRepository.deleteById(id);
    }
}
