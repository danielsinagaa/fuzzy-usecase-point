package com.usecasepoint.service;

import com.usecasepoint.entity.Aktor;
import com.usecasepoint.entity.Metrics;
import com.usecasepoint.entity.Proyek;
import com.usecasepoint.entity.UseCase;
import com.usecasepoint.repository.ProyekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProyekService extends AbstractService<Proyek> {
    @Autowired
    private TCFService tcfService;

    @Autowired
    private MetricService metricService;

    @Autowired
    private EFService efService;

    @Autowired
    private AktorService aktorService;

    @Autowired
    private ProyekRepository proyekRepository;

    @Autowired
    private UseCaseService useCaseService;

    @Autowired
    public ProyekService(ProyekRepository repository) {
        super(repository);
    }

    public Proyek findByMetrics(Metrics metrics){
        return proyekRepository.findProyekByMetrics(metrics);
    }

    public void deleteByProyek(String id) {

        Proyek proyek = findById(id);

        efService.deleteAllByProyek(id);
        tcfService.deleteAllByProyek(id);
        aktorService.deleteAllByProyek(id);
        useCaseService.deleteAllByProyek(id);

        deleteById(id);

        metricService.deleteById(proyek.getMetrics().getId());
    }

    public Proyek changeAmount(Proyek proyek){
        proyekRepository.save(proyek);

        return proyek;
    }

    @Override
    public Proyek save(Proyek entity) {
        Metrics metrics = new Metrics(entity.getNama(), entity.getEffort().doubleValue());

        metricService.save(metrics);

        entity.setMetrics(metrics);

        super.save(entity);

        for (int i = 1; i <= 13; i++) {
            tcfService.saveTCF(entity, "T" + i);

            if (i < 9){
                efService.save(entity, "E"+i);
            }
        }

        for (int i = 1; i <= entity.getJumlahAktor(); i++){
            Aktor aktor = new Aktor();
            aktor.setProyek(entity);
            aktor.setKategori("complex");
            aktor.setNama("aktor baru");

            aktorService.save(aktor);
        }

        for (int i = 1; i <= entity.getJumlahUseCase(); i++){
            UseCase useCase = new UseCase();
            useCase.setProyek(entity);
            useCase.setName("usecase baru");
            useCase.setJumlahTransaksi(1);

            useCaseService.save(useCase);
        }

        return entity;
    }

    public Proyek edit(Proyek entity) {
        Metrics metrics = entity.getMetrics();

        metricService.save(metrics);

        entity.setMetrics(metrics);

        super.save(entity);

        efService.deleteAllByProyek(entity.getId());
        tcfService.deleteAllByProyek(entity.getId());
        aktorService.deleteAllByProyek(entity.getId());
        useCaseService.deleteAllByProyek(entity.getId());

        for (int i = 1; i <= 13; i++) {
            tcfService.saveTCF(entity, "T" + i);

            if (i < 9){
                efService.save(entity, "E"+i);
            }
        }

        for (int i = 1; i <= entity.getJumlahAktor(); i++){
            Aktor aktor = new Aktor();
            aktor.setProyek(entity);
            aktor.setKategori("complex");
            aktor.setNama("aktor baru");

            aktorService.save(aktor);
        }

        for (int i = 1; i <= entity.getJumlahUseCase(); i++){
            UseCase useCase = new UseCase();
            useCase.setProyek(entity);
            useCase.setName("usecase baru");
            useCase.setJumlahTransaksi(1);

            useCaseService.save(useCase);
        }

        return entity;
    }
}
