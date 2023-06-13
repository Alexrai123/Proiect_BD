package com.proiect.bazededate.service;

import com.proiect.bazededate.models.Echipa;
import com.proiect.bazededate.models.Meci;
import com.proiect.bazededate.repository.EchipaRepository;
import com.proiect.bazededate.repository.MeciRepository;
import com.proiect.bazededate.repository.StadionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MeciService {

    private final MeciRepository meciRepository;
    private final EchipaRepository echipaRepository;
    private final StadionRepository stadionRepository;

    public Meci create(Meci meci) throws Exception {
        Meci meciToCreate = new Meci();
        meciToCreate.setDateMeciului(meci.getDateMeciului());
        Echipa gazde = echipaRepository.findById(meci.getGazde().getId()).orElse(null);
        Echipa oaspeti = echipaRepository.findById(meci.getOaspeti().getId()).orElse(null);
        if (Objects.equals(gazde, oaspeti)) {
            throw new Exception("Gazdele trebuie sa fie diferite de oaspeti");
        }
        meciToCreate.setLocatie(stadionRepository.findById(meci.getLocatie().getId()).orElse(null));
        meciToCreate.setGazde(gazde);
        meciToCreate.setOaspeti(oaspeti);

        return meciRepository.save(meciToCreate);
    }

    public Meci getOne(UUID idMeci) {
        return meciRepository.findById(idMeci).orElseThrow(null);
    }

    public Meci update(Meci meciToUpdate) throws Exception {

        Meci meci = meciRepository.findById(meciToUpdate.getId()).orElse(new Meci());
        meci.setDateMeciului(meciToUpdate.getDateMeciului());
        Echipa gazde = echipaRepository.findById(meci.getGazde().getId()).orElse(null);
        Echipa oaspeti = echipaRepository.findById(meci.getOaspeti().getId()).orElse(null);
        if (Objects.equals(gazde, oaspeti)) {
            throw new Exception("Gazdele trebuie sa fie diferite de oaspeti");
        }
        meci.setGazde(gazde);
        meci.setOaspeti(oaspeti);
        meci.setLocatie(stadionRepository.findById(meci.getLocatie().getId()).orElse(null));
        return meciRepository.save(meci);
    }

    public void delete(UUID idMeci) throws Exception {
        Meci meci = meciRepository.findById(idMeci).orElse(null);
        if (Objects.equals(null, meci)) {
            throw new Exception("Entity not found");
        }

        meciRepository.delete(meci);
    }
}
