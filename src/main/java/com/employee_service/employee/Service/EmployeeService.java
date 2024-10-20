package com.employee_service.employee.Service;

import com.employee_service.employee.DTO.EmployeeDto;
import com.employee_service.employee.Entity.Employee;
import com.employee_service.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee_service.employee.Exceptions.DepartmentNotFoundException;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {


        Employee employee= new Employee(employeeDto.getId(),employeeDto.getFirstname(),employeeDto.getLastname(),employeeDto.getEmail(),employeeDto.getDepartmentcode());

Employee savedEmployee=employeeRepository.save(employee);
EmployeeDto saevdEmployeeDto= new EmployeeDto(savedEmployee.getId(),savedEmployee.getFirstname(),savedEmployee.getLastname(), savedEmployee.getEmail(), savedEmployee.getDepartmentcode());
return saevdEmployeeDto;
    }

    public EmployeeDto getEmpById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new DepartmentNotFoundException(id));
        EmployeeDto employeeDto= new EmployeeDto(employee.getId(),employee.getFirstname(),employee.getLastname(),employee.getEmail(),employee.getDepartmentcode());
        return employeeDto;

    }
}
