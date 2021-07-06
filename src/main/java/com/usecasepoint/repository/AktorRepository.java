package com.usecasepoint.repository;

import com.usecasepoint.entity.Aktor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AktorRepository extends JpaRepository<Aktor, String> {
    List<Aktor> findAllByProyekId(String proyekId);
    List<Aktor> deleteAllByProyekId(String proyekId);
}
