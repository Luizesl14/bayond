package com.dvp.bayond.domain.vo;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IResource<T> {
    ResponseEntity<List<T>>getAllModels();
    ResponseEntity<T> getByIdModel(Integer id);
    ResponseEntity<T> save(T t);
    ResponseEntity<T> update(T t);
    ResponseEntity<T> deletById(Integer id);
}
