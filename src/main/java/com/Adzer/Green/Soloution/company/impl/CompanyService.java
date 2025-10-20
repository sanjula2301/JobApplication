package com.Adzer.Green.Soloution.company.impl;

import com.Adzer.Green.Soloution.company.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    Company createCompany(Company company);
    List<Company> getAllCompanies();
    Optional<Company> getCompanyById(Long id);
    Company updateCompany(Long id, Company companyDetails);
    boolean deleteCompany(Long id);
}
