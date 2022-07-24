package com.dvp.bayond.service;

import com.dvp.bayond.domain.model.*;
import com.dvp.bayond.domain.vo.IService;
import com.dvp.bayond.repository.ICategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements IService<Category> {


    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAllModels() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category findByIdModel(Integer id) {
        Optional<Category> category = Optional.ofNullable(this.categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Model not found!")));
        return category.get();
    }

    @Override
    public Category saveModel(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Category updateModel(Category category) {
        return null;
    }

    @Override
    public void deletModelById(Integer id) {

    }
}
