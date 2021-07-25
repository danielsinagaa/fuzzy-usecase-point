package com.usecasepoint.service;

import com.usecasepoint.entity.*;
import com.usecasepoint.entity.enumcons.EFEnum;
import com.usecasepoint.entity.enumcons.TCFEnum;
import com.usecasepoint.entity.enumcons.UAW;
import com.usecasepoint.repository.MetricsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@Service
@Transactional
public class MetricService extends AbstractService<Metrics> {
    @Autowired
    private ProyekService proyekService;

    @Autowired
    private AktorService aktorService;

    @Autowired
    private UseCaseService useCaseService;

    @Autowired
    private TCFService tcfService;

    @Autowired
    private EFService efService;

    @Autowired
    public MetricService(MetricsRepository repository) {
        super(repository);
    }

    public Metrics deleteByMetrics(String id) {
        Metrics metrics = findById(id);

        Proyek proyek = new Proyek();

        try {
            proyek = proyekService.findByMetrics(metrics);
        } catch (NullPointerException e){
            List<Proyek> proyeks = proyekService.findAll();
            for (Proyek p : proyeks){
                if (p.getMetrics() == metrics){
                    proyek = p;
                }
            }
        }

        proyekService.deleteByProyek(proyek.getId());

        return metrics;
    }

    public Metrics updateValue(String proyekId){
        Proyek proyek = proyekService.findById(proyekId);
        Metrics metrics = proyek.getMetrics();

        List<Aktor> aktors = aktorService.findAllByProyekId(proyek.getId());

        int simple = 0;
        int average = 0;
        int complex = 0;

        for (Aktor a : aktors){
            if (a.getKategori().equals(UAW.AVERAGE.getType())){
                average += 1;
            } else if (a.getKategori().equals(UAW.COMPLEX.getType())){
                complex += 1;
            } else {
                simple += 1;
            }
        }

        int uaw = simple + (average * 2) + (complex * 3);

        List<UseCase> useCases = useCaseService.findAllByProyekId(proyekId);

        simple = 0;
        average = 0;
        complex = 0;
        double fucpUucw = 0;

        for (UseCase u : useCases){
            if (u.getJumlahTransaksi() <= 3){
                simple += 1;
            } else if (u.getJumlahTransaksi() >= 4 && u.getJumlahTransaksi() <= 7){
                average += 1;
            } else {
                complex += 1;
            }

            switch (u.getJumlahTransaksi()){
                case 1:
                case 2:
                    fucpUucw += 5.00;
                    break;
                case 3:
                    fucpUucw += 6.45;
                    break;
                case 4:
                    fucpUucw += 7.5;
                    break;
                case 5:
                    fucpUucw += 8.55;
                    break;
                case 6:
                    fucpUucw += 10.00;
                    break;
                case 7:
                    fucpUucw += 11.4;
                    break;
                case 8:
                    fucpUucw += 12.5;
                    break;
                case 9:
                    fucpUucw += 13.6;
                    break;
                case 10:
                case 12:
                case 11:
                    fucpUucw += 15.00;
                    break;
            }
        }

        int uucw = (simple * 5) + (average * 10) + (complex * 15);

        int uucp = uaw + uucw;
        double fucpUucp = fucpUucw + uaw;

        List<TCFEnum> tcfEnum = new ArrayList<>(EnumSet.allOf(TCFEnum.class));

        List<TCF> tcfs = tcfService.findAllByProyekId(proyekId);

        double tfactor = 0.0;

        for (TCFEnum e : tcfEnum) {
            for (TCF tcf : tcfs){
                if (tcf.getCode().equals(e.name())){
                    tfactor += (tcf.getValue() * e.getBobot());
                }
            }
        }

        double tcfResult = 0.6 + (0.01 * tfactor);

        List<EFEnum> efEnum = new ArrayList<>(EnumSet.allOf(EFEnum.class));

        List<EF> efs = efService.findAllByProyekId(proyekId);

        double efactor = 0.0;

        for (EFEnum e : efEnum){
            for (EF ef: efs){
                if (ef.getCode().equals(e.name())){
                    efactor += (ef.getValue() * e.getBobot());
                }
            }
        }

        double efResult = 1.4 + (-0.03 * efactor);

        efResult = Math.ceil(efResult * 100) / 100;

        double UCP = (uucp * tcfResult * efResult) * 20;
        double fucpUCP = (fucpUucp * tcfResult * efResult) * 20;

        double merucp = Math.abs(metrics.getActual() - UCP) / UCP;
        double merfucp = Math.abs(metrics.getActual() - fucpUCP) / fucpUCP;

        double mreucp = Math.abs(metrics.getActual() - UCP) / metrics.getActual();
        double mrefucp = Math.abs(metrics.getActual() - fucpUCP) / metrics.getActual();

        metrics.setMerFUCP(parseDecimal(merfucp));
        metrics.setMerUCP(parseDecimal(merucp));
        metrics.setMreUCP(parseDecimal(mreucp) );
        metrics.setMreFUCP(parseDecimal(mrefucp));
        metrics.setEffortUCP(parseDecimal(UCP) );
        metrics.setEffortFUCP(parseDecimal(fucpUCP) );
        metrics.setErrorUCP(parseDecimal(Math.abs(metrics.getActual() - UCP)));
        metrics.setErrorFUCP(parseDecimal(Math.abs(metrics.getActual() - fucpUCP)));
        save(metrics);

        return metrics;
    }

    private Double parseDecimal(Double number){
        try {
            number = Double.parseDouble(new DecimalFormat("##.###").format(number));
        } catch (NumberFormatException e){

        }

        return number;
    }
}
