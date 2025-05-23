package com.example.app.comapny.impl;

import com.example.app.comapny.CompRepositary;
import com.example.app.comapny.Company;
import com.example.app.comapny.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class companyServiceimpl implements CompanyService {

    private CompRepositary compRepositary;

    public companyServiceimpl(CompRepositary compRepositary) {
        this.compRepositary = compRepositary;
    }

    @Override
    public List<Company> findAll() {
        return compRepositary.findAll();
    }

    @Override
    public void createCompany(Company company) {
         compRepositary.save(company);
    }

    @Override
    public Company getById(Long id) {
        return compRepositary.findById(id).orElse(null);
    }


    @Override
    public boolean updateCompany(Long id, Company updatedCompany) {
        Optional<Company> optionalCompany = compRepositary.findById(id);
        if(optionalCompany.isPresent()){
            Company company = optionalCompany.get();
                company.setName(updatedCompany.getName());
                company.setLocation(updatedCompany.getLocation());
                company.setMembers(updatedCompany.getMembers());
                company.setJob(updatedCompany.getJob());
                compRepositary.save(company);
            return true;
        }
        return false;
    }

    @Override
    public boolean delById(Long id) {
        try{
            compRepositary.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
