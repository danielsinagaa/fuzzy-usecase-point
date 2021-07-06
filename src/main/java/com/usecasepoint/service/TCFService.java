package com.usecasepoint.service;

import com.usecasepoint.entity.Proyek;
import com.usecasepoint.entity.TCF;
import com.usecasepoint.repository.TCFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TCFService extends AbstractService<TCF>{
    @Autowired
    private TCFRepository repository;

    @Autowired
    public TCFService(TCFRepository repository) {
        super(repository);
    }

    @Autowired
    private MetricService metricService;

    public TCF saveTCF(Proyek proyek, String code){
        TCF tcf = new TCF();
        tcf.setProyek(proyek);
        tcf.setCode(code);
        tcf.setValue(0.0);
        return repository.save(tcf);
    }

    public TCF saveValue(TCF entity) {
        return changeValue(entity.getId(), entity.getValue());
    }

    public void deleteAllByProyek(String id){
        repository.deleteAllByProyekId(id);
    }

    public List<TCF> findAllByProyekId(String proyekId){
        return repository.findAllByProyekId(proyekId);
    }

    public TCF changeValue(String tcfId, Double value){
        TCF tcf = findById(tcfId);
        Proyek proyek = tcf.getProyek();

        tcf.setValue(value);
        save(tcf);

        metricService.updateValue(proyek.getId());
        return tcf;
    }
}
