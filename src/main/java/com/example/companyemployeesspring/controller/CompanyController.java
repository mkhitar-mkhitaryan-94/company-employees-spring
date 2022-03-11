package com.example.companyemployeesspring.controller;

import com.example.companyemployeesspring.entity.Company;
import com.example.companyemployeesspring.service.CompanyService;
import com.example.companyemployeesspring.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;
    private final EmployeeService employeeService;

    @GetMapping("/companies")
    public String getAllCompanies(ModelMap map) {
        map.addAttribute("companies", companyService.findAll());
        return "companies";
    }


    @PostMapping("/addCompany")
    public String addCompany(@ModelAttribute Company company) {
        companyService.save(company);
        return "redirect:/companies";
    }


    @GetMapping("/deleteCompany/{id}")
    public String deleteCompany(@PathVariable int id) {
        employeeService.deleteEmployeesByCompany_Id(id);
        companyService.deleteById(id);

        return "redirect:/companies";
    }
}
