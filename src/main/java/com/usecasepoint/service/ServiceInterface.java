package com.usecasepoint.service;

import java.util.List;

public interface ServiceInterface<T, ID> {
    T findById(ID id);
    List<T> findAll();
    T deleteById(ID id);
    T save(T entity);
}
