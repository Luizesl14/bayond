package com.dvp.bayond.service;

import com.dvp.bayond.domain.model.Product;
import com.dvp.bayond.domain.vo.IService;
import com.dvp.bayond.repository.IProductRepository;
import com.dvp.bayond.service.exception.ObjectNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IService<Product> {


    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> findAllModels() {
        return this.productRepository.findAll();
    }

    @Override
    public Product findByIdModel(Integer id) {
        Optional<Product> category = Optional.ofNullable(this.productRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Produto não encontrado! id " +id )));
        return category.get();
    }

    @Override
    public Product saveModel(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public Product updateModel(Product product) {
        Product productDatabase = this.findByIdModel(product.getId());
        BeanUtils.copyProperties(product, productDatabase, "id");
        return this.productRepository.save(productDatabase);
    }

    @Override
    public void deletModelById(Integer id) {

    }
}
