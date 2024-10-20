package com.employee_service.employee.Controller;
//import com.employee_service.employee.DTO.APIResponseDto;
import com.employee_service.employee.DTO.EmployeeDto;
import com.employee_service.employee.Service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/savedEmp")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){

        EmployeeDto savedDto= employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedDto, HttpStatus.CREATED);

    }
    @GetMapping("/getemp/{Id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long Id){
        EmployeeDto ResponseDto= employeeService.getEmpById(Id);
        return new ResponseEntity<>(ResponseDto,HttpStatus.OK);

    }

}