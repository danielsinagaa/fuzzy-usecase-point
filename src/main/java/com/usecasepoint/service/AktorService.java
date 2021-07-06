package com.usecasepoint.service;

import com.usecasepoint.entity.Aktor;
import com.usecasepoint.entity.Metrics;
import com.usecasepoint.entity.Proyek;
import com.usecasepoint.entity.enumcons.UAW;
import com.usecasepoint.model.AktorRequest;
import com.usecasepoint.repository.AktorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Service
@Transactional
public class AktorService extends AbstractService<Aktor> {
    @Autowired
    private AktorRepository repository;

    @Autowired
    private ProyekService proyekService;

    @Autowired
    private MetricService metricService;

    @Autowired
    public AktorService(AktorRepository repository) {
        super(repository);
    }

    public Aktor save(AktorRequest entity) {
        Proyek proyek = proyekService.findById(entity.getProyekId());

        Aktor aktor = new Aktor(entity.getNama(), entity.getKategori(),proyek);

        save(aktor);

        metricService.updateValue(entity.getProyekId());

        return aktor;
    }

    public void deleteAllByProyek(String id){
        repository.deleteAllByProyekId(id);
    }

    public List<Aktor> findAllByProyekId(String proyekId){
        return repository.findAllByProyekId(proyekId);
    }
}
