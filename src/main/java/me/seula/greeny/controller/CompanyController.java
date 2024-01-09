package me.seula.greeny.controller;

import lombok.RequiredArgsConstructor;
import me.seula.greeny.domain.CompanyEntity;
import me.seula.greeny.domain.ProductEntity;
import me.seula.greeny.dto.CompanyDTO;
import me.seula.greeny.service.CompanyService;
import me.seula.greeny.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;
    private final ProductService productService;

    @GetMapping
    public List<CompanyEntity> getCompanyList() {
        return companyService.getCompanyList();
    }

    @GetMapping("/{companyName}")
    public CompanyEntity getCompany(@PathVariable("companyName") String companyName) {
        return companyService.getCompany(companyName);
    }
    @GetMapping("/{companyName}/products")
    public List<ProductEntity> getCompanyProduct(@PathVariable("companyName") String companyName) {
        return productService.getCompanyProduct(companyName);
    }

    @PostMapping
    public void createCompany(CompanyDTO companyDTO) {
        companyService.createCompany(companyDTO);
    }

}
