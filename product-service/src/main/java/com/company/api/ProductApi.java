package com.company.api;


import com.company.dto.ProductDTO;
import com.company.dto.request.CreateProductDTORequest;
import com.company.dto.request.UpdateProductDTORequest;
import com.company.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/product")
@RequiredArgsConstructor
public class ProductApi {

    private final ProductService productService;


    @PostMapping("/add")
    public ResponseEntity<ProductDTO> createProduct(
            @RequestBody CreateProductDTORequest createProductDTORequest) {
        return ResponseEntity.ok(productService.createProduct(createProductDTORequest));
    }


    @PutMapping("/update")
    public ResponseEntity<ProductDTO> updateProduct(
            @Valid @RequestBody UpdateProductDTORequest updateProductDTORequest) {
        return ResponseEntity.ok(productService.updateProduct(updateProductDTORequest));
    }


    @GetMapping("/getall")
    public ResponseEntity<List<ProductDTO>> getAllProduct() {
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable(value = "id", required = true) Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

}