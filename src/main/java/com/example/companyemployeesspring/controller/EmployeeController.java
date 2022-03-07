package com.example.companyemployeesspring.controller;

import com.example.companyemployeesspring.entity.Employee;
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
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CompanyRepository companyRepository;


    @GetMapping("/employees")
    public String getAllEmployees(ModelMap map){
        List<Employee> employees = employeeRepository.findAll();
        map.addAttribute("employees",employees);
        map.addAttribute("companies", companyRepository.findAll());
        return "employees";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id){
        employeeRepository.deleteById(id);
        return "redirect:/employees";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute Employee employee){
        employeeRepository.save(employee);
        return "redirect:/employees";
    }
}
