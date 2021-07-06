package com.usecasepoint.service;

import com.usecasepoint.entity.Proyek;
import com.usecasepoint.entity.UseCase;
import com.usecasepoint.model.UseCaseRequest;
import com.usecasepoint.repository.UseCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UseCaseService extends AbstractService<UseCase> {
    @Autowired
    private UseCaseRepository repository;

    @Autowired
    private ProyekService proyekService;

    @Autowired
    private MetricService metricService;

    public UseCaseService(UseCaseRepository repository) {
        super(repository);
    }

    public UseCase save(UseCaseRequest request){
        Proyek proyek = proyekService.findById(request.getProyekId());

        UseCase useCase = new UseCase(request.getName(), request.getJumlahTransaksi(), proyek);

        save(useCase);

        metricService.updateValue(proyek.getId());

        return useCase;
    }

    public void deleteAllByProyek(String id){
        repository.deleteAllByProyekId(id);
    }

    public List<UseCase> findAllByProyekId(String proyekId){
        return repository.findAllByProyekId(proyekId);
    }
}
