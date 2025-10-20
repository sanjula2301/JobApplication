package com.Adzer.Green.Soloution.company.impl;

import com.Adzer.Green.Soloution.company.Company;
import com.Adzer.Green.Soloution.company.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Optional<Company> getCompanyById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public Company updateCompany(Long id, Company companyDetails) {
        return companyRepository.findById(id).map(existingCompany -> {
            existingCompany.setCompanyName(companyDetails.getCompanyName());
            existingCompany.setDescription(companyDetails.getDescription());
            existingCompany.setIndustry(companyDetails.getIndustry());
            existingCompany.setLocation(companyDetails.getLocation());
            return companyRepository.save(existingCompany);
        }).orElse(null);
    }

    @Override
    public boolean deleteCompany(Long id) {
        if (companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
