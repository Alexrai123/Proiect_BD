package com.proiect.bazededate.service;

import com.proiect.bazededate.models.Jucator;
import com.proiect.bazededate.repository.EchipaRepository;
import com.proiect.bazededate.repository.JucatorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class JucatorService {
    private final JucatorRepository jucatorRepository;
    private final EchipaRepository echipaRepository;

    public Jucator create(Jucator jucator) {
        Jucator jucatorToCreate = new Jucator();
        jucatorToCreate.setNume(jucator.getNume());
        jucatorToCreate.setPrenume(jucator.getPrenume());
        jucatorToCreate.setPozitie(jucator.getPozitie());
        jucatorToCreate.setTaraOrigine(jucator.getTaraOrigine());
        jucatorToCreate.setEchipa(echipaRepository.findById(jucator.getEchipa().getId()).orElse(null));
        //asta trebuie ? e cheie straina plm: jucatorToCreate.setEchipa(jucator.getEchipa());
        return jucatorRepository.save(jucatorToCreate);
    }

    public Jucator getOne(UUID idJucator) {
        return jucatorRepository.findById(idJucator).orElseThrow(null);
    }

    public Jucator update(Jucator jucatorToUpdate) {
        Jucator jucator = jucatorRepository.findById(jucatorToUpdate.getId()).orElse(new Jucator());
        jucator.setNume(jucatorToUpdate.getNume());
        jucator.setPrenume(jucatorToUpdate.getPrenume());
        jucator.setPozitie(jucatorToUpdate.getPozitie());
        return jucatorRepository.save(jucator);
    }

    public void delete(UUID idJucator) throws Exception {
        Jucator jucator = jucatorRepository.findById(idJucator).orElse(null);
        if (Objects.equals(null, jucator)) {
            throw new Exception("Entity not found");
        }
        jucatorRepository.delete(jucator);
    }
}
