package mohammedkeyse.application.controller;

import mohammedkeyse.application.dto.EmployeeDto;
import mohammedkeyse.application.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/api/employees")
public class EmployeeController {


    private EmployeeService employeeService;

    // Build Add Emploee REST API

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee (@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }


    // Build get EmployeeById Rest API
    @GetMapping("{id}")

    public  ResponseEntity<EmployeeDto> getEmployeeById (@PathVariable("id") Long employeeId){
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }

}
