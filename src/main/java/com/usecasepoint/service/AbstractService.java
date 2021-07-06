package com.usecasepoint.service;

import com.usecasepoint.exception.EntityNotFoundEx;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class AbstractService<T> implements ServiceInterface<T, String>{

    protected final JpaRepository<T, String> repository;

    public AbstractService(JpaRepository<T, String> repository) {
        this.repository = repository;
    }

    @Override
    public T findById(String id) {
        return repository.findById(id).orElseThrow(EntityNotFoundEx::new);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public T deleteById(String id) {
        T entity = findById(id);
        repository.deleteById(id);
        return entity;
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }
}
