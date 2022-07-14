package com.dvp.bayond.resources;

import com.dvp.bayond.domain.model.Category;
import com.dvp.bayond.domain.vo.IResource;
import com.dvp.bayond.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CategoryResource  implements IResource<Category> {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    @Override
    public ResponseEntity<List<Category>> getAllModels() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.categoryService.findAllModels());
    }

    @GetMapping(value = "/{id}")
    @Override
    public ResponseEntity<Category> getByIdModel(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.categoryService.findByIdModel(id));
    }

    @PostMapping(value = "/save")
    @Override
    public ResponseEntity<Category> save(@RequestBody Category category) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.categoryService.saveModel(category));
    }

    @PutMapping(value = "/update")
    @Override
    public ResponseEntity<Category> update(@RequestBody Category category) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(this.categoryService.updateModel(category));
    }

    @DeleteMapping(value = "/delete/{id}")
    @Override
    public ResponseEntity<Category> deletById(@PathVariable Integer id) {
        this.categoryService.deletModelById(id);
        return ResponseEntity.ok().build();
    }
}
