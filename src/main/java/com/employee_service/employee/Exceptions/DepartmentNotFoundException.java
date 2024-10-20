package com.employee_service.employee.Exceptions;

public class DepartmentNotFoundException extends  RuntimeException{

    public DepartmentNotFoundException(Long id){
        super("Department Not found wit id "+ id);
    }
}
