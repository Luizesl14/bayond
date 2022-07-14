package com.dvp.bayond.domain.vo;

import java.util.List;

public interface IService<T> {
    List<T> findAllModels();
    T findByIdModel(Integer id);
    T saveModel(T t);
    T updateModel(T t);
    void deletModelById(Integer id);

}
