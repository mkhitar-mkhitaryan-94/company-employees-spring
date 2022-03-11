package com.example.companyemployeesspring.service;

import com.example.companyemployeesspring.dto.CreateEmployeeRequest;
import com.example.companyemployeesspring.entity.Employee;
import com.example.companyemployeesspring.entity.Picture;
import com.example.companyemployeesspring.repository.CompanyRepository;
import com.example.companyemployeesspring.repository.EmployeeRepository;
import com.example.companyemployeesspring.repository.PictureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;
    private final PictureRepository pictureRepository;

   @Value("${springEmployee.upload.path}")
   private String imagePath;

    public void deleteEmployeesByCompany_Id(int id) {
        employeeRepository.deleteEmployeesByCompany_Id(id);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

    public void addEmployeeFromEmployeeRequest(CreateEmployeeRequest employeeRequest, MultipartFile[] uploadedFiles) throws IOException {
        Employee employee = getEmployeeFromRequest(employeeRequest);
        employeeRepository.save(employee);
        saveEmployeeImages(uploadedFiles,employee);
    }

    private void saveEmployeeImages(MultipartFile[] uploadedFiles, Employee employee) throws  IOException {
        if(uploadedFiles.length != 0){
            for (MultipartFile uploadedFile : uploadedFiles) {
                String fileName = System.currentTimeMillis() + "_" + uploadedFile.getOriginalFilename();
                File newFile = new File(imagePath + fileName);
                uploadedFile.transferTo(newFile);
                Picture picture = Picture.builder()
                        .employee(employee)
                        .name(fileName)
                        .build();
                pictureRepository.save(picture);
            }
        }
    }

    private Employee getEmployeeFromRequest(CreateEmployeeRequest employeeRequest) {
        return Employee.builder()
                .name(employeeRequest.getName())
                .surname(employeeRequest.getSurname())
                .email(employeeRequest.getEmail())
                .phoneNumber(employeeRequest.getPhoneNumber())
                .salary(employeeRequest.getSalary())
                .position(employeeRequest.getPosition())
                .company(companyRepository.findById(employeeRequest.getCompanyId()).orElse(null))
                .build();
    }
}
