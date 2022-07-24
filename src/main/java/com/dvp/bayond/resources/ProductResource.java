package com.dvp.bayond.resources;

import com.dvp.bayond.domain.model.Product;
import com.dvp.bayond.domain.vo.IResource;
import com.dvp.bayond.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductResource implements IResource<Product> {

    @Autowired
    private ProductService productService;

    @GetMapping
    @Override
    public ResponseEntity<List<Product>> getAllModels() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.productService.findAllModels());
    }

    @GetMapping(value = "/{id}")
    @Override
    public ResponseEntity<Product> getByIdModel(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.productService.findByIdModel(id));
    }

    @PostMapping
    @Override
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.productService.saveModel(product));
    }

    @PutMapping
    @Override
    public ResponseEntity<Product> update(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(this.productService.updateModel(product));
    }

    @DeleteMapping(value = "/{id}")
    @Override
    public ResponseEntity<Product> deletById(@PathVariable Integer id) {
        this.productService.deletModelById(id);
        return ResponseEntity.ok().build();
    }
}
