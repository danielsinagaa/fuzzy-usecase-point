package com.usecasepoint.service;

import com.usecasepoint.entity.EF;
import com.usecasepoint.entity.Proyek;
import com.usecasepoint.entity.TCF;
import com.usecasepoint.repository.EFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EFService extends AbstractService<EF> {
    @Autowired
    private EFRepository repository;

    @Autowired
    private MetricService metricService;

    @Autowired
    public EFService(EFRepository repository) {
        super(repository);
    }

    public EF save(Proyek proyek, String code){
        EF ef = new EF(code, proyek);
        ef.setValue(0.0);

        save(ef);

        metricService.updateValue(proyek.getId());

        return ef;
    }

    public EF saveValue(EF entity) {
        return changeValue(entity.getId(), entity.getValue());
    }

    public void deleteAllByProyek(String id){
        repository.deleteAllByProyekId(id);
    }

    public EF changeValue(String efId, Double value){
        EF ef = findById(efId);
        Proyek proyek = ef.getProyek();

        ef.setValue(value);
        save(ef);

        metricService.updateValue(proyek.getId());
        return ef;
    }

    public List<EF> findAllByProyekId(String proyekId){
        return repository.findAllByProyekId(proyekId);
    }
}
