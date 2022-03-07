package com.example.companyemployeesspring.controller;

import com.example.companyemployeesspring.entity.Company;
import com.example.companyemployeesspring.repository.CompanyRepository;
import com.example.companyemployeesspring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/companies")
    public String getAllCompanies(ModelMap map) {
        List<Company> companies = companyRepository.findAll();
        map.addAttribute("companies", companies);
        return "companies";
    }


    @PostMapping("/addCompany")
    public String addCompany(@ModelAttribute Company company) {
        companyRepository.save(company);
        return "redirect:/companies";
    }


    @GetMapping("/deleteCompany/{id}")
    public String deleteCompany(@PathVariable int id) {
        employeeRepository.deleteEmployeesByCompany_Id(id);
        companyRepository.deleteById(id);

        return "redirect:/companies";
    }
}
