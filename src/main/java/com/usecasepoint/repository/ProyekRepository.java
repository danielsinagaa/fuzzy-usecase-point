package com.usecasepoint.repository;

import com.usecasepoint.entity.Metrics;
import com.usecasepoint.entity.Proyek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyekRepository extends JpaRepository<Proyek, String> {
    Proyek findProyekByMetrics(Metrics metrics);
}
