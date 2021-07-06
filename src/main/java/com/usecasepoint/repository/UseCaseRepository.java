package com.usecasepoint.repository;

import com.usecasepoint.entity.UseCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UseCaseRepository extends JpaRepository<UseCase, String> {
    List<UseCase> findAllByProyekId(String proyekId);
    List<UseCase> deleteAllByProyekId(String proyekId);
}
