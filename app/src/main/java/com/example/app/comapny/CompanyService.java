package com.example.app.comapny;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();

    void createCompany(Company company);

   Company getById(Long id);

    boolean updateCompany(Long id, Company updatedCompany);

    boolean delById(Long id);
}
