package com.crm.controller;

import com.crm.entity.Employee;
import com.crm.payload.EmployeeDto;
import com.crm.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController  /* RestController annotation acts like controller layer b/w the postman(client side) and controller
 layer for now and the data will come in the form of JSON format */
//when we click send(URL) button on client side(postman) it will call this controller class.
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //http://localhost:8080/api/v1/employee/add
    @PostMapping("/add")
     public ResponseEntity<?> addEmployee(
            @Valid  @RequestBody EmployeeDto dto,  //RequestBody annotation will read the data from the request body(JSON) and store it in the employee object(Java Object).
            BindingResult result //BindingResult is special class it will capture the error automatically when error occured in EmployeeDto.
){
        if(result.hasErrors()){
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
      EmployeeDto employeeDto= employeeService.addEmployee(dto);
        return new ResponseEntity<>(employeeDto , HttpStatus.CREATED);

     }


     //http://localhost:8080/api/v1/employee?id=1
    @DeleteMapping
     public ResponseEntity<String> deleteEmployee(
             @RequestParam Long id
     ){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<EmployeeDto> updateEmployee(
            @RequestParam Long id,
            @RequestBody EmployeeDto dto
    ){
        EmployeeDto employeeDto = employeeService.updateEmployee(id, dto);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }


    //http://localhost:8080/api/v1/employee?pageSize=3&pageNo=1&sortBy=emailId&sortDir=asc
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getEmployees(
            @RequestParam(name = "pageNo", required=false , defaultValue = "0") int pageNo,
            @RequestParam(name = "pageSize",required=false , defaultValue = "5") int pageSize,
            @RequestParam(name = "sortBy", required=false , defaultValue = "name") String sortBy,
            @RequestParam(name = "sortDir", required=false , defaultValue = "asc") String sortDir

    ){
        List<EmployeeDto> employeesDto=employeeService.getEmployee(pageNo,pageSize,sortBy,sortDir);
        return new ResponseEntity<>(employeesDto, HttpStatus.OK);
    }

        //http://localhost:8080/api/v1/employee/employeeId/1
    @GetMapping("/employeeId/{empId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(
    @PathVariable long empId
    ){
        EmployeeDto dto=employeeService.getEmployeeById(empId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}