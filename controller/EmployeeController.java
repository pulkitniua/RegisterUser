package com.example.RegisterUser.controller;

import com.example.RegisterUser.Dto.EmployeeDTO;
import com.example.RegisterUser.entity.Employee;
import com.example.RegisterUser.jwtkey.JwtConfig;
import com.example.RegisterUser.repo.EmployeeRepo;
import com.example.RegisterUser.service.EmployeeService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.security.Key;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin
@RequestMapping("api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(path = "/save")
    public String saveEmployee(@RequestBody EmployeeDTO employeeDTO)
    {
        String id = employeeService.addEmployee(employeeDTO);
        return id;
    }
    
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private Key secretKey;
    
    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody Map<String, String> loginData) {
        String username = loginData.get("username");
        String password = loginData.get("password");

        Employee employee = employeeRepo.findByUsername(username);

        if (employee == null || !employee.getPassword().equals(password)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
       
        // Generate a JWT
        @SuppressWarnings("deprecation")
		String token = Jwts.builder()
                .setSubject(employee.getUsername())
                .signWith(SignatureAlgorithm.HS384, "secretKey") // Replace with your own secret key
                .compact();

     // Return success response with token
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        return ResponseEntity.ok(response);
        

     }
    
    


	// method to fetch data from postgres database
	
	@GetMapping("/getData")
	public List<Employee> getAllData(){
		
		return employeeRepo.findAll();
	}
	
}
