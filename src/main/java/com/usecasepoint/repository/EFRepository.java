package com.usecasepoint.repository;

import com.usecasepoint.entity.EF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EFRepository extends JpaRepository<EF, String> {
    List<EF> findAllByProyekId(String proyekId);
    List<EF> deleteAllByProyekId(String proyekId);
}
