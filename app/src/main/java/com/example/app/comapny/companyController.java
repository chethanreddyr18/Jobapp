package com.example.app.comapny;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class companyController {
   CompanyService companyService;

    public companyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/companies")
    public ResponseEntity<List<Company>> findAll(){
        return new ResponseEntity<>(companyService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/companies/{id}")
    public ResponseEntity<Company> getById(@PathVariable Long id){
        Company company = companyService.getById(id);
        if(company != null)
            return new ResponseEntity<>(company,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/companies")
    public ResponseEntity<String> createCompany(@RequestBody Company company){
         companyService.createCompany(company);
         return new ResponseEntity<>("succesfull",HttpStatus.OK);
    }

    @PutMapping("/companies/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id,@RequestBody Company updatedCompany){
          boolean com = companyService.updateCompany(id,updatedCompany);
        if(com){
            return new ResponseEntity<>("Updated",HttpStatus.OK);
        }
        return new ResponseEntity<>("Not Updated",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/companies/{id}")

    public ResponseEntity<String> deleteById(@PathVariable Long id){
        boolean del = companyService.delById(id);
        if(del)
            return new ResponseEntity<>("deleted",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
