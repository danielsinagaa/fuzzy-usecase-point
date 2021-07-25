package com.usecasepoint.repository;

import com.usecasepoint.entity.Proyek;
import com.usecasepoint.entity.TCF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TCFRepository extends JpaRepository<TCF, String> {
    List<TCF> findAllByProyekId(String proyekId);
    List<TCF> deleteAllByProyekId(String proyekId);
}
