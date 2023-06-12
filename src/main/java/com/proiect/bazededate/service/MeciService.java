package com.proiect.bazededate.service;

import com.proiect.bazededate.models.Meci;
import com.proiect.bazededate.repository.MeciRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MeciService {

    private final MeciRepository meciRepository;

    public Meci create(Meci meci) {
        Meci meciToCreate = new Meci();
        meciToCreate.setDateMeciului(meci.getDateMeciului());
        //meciToCreate.setGazde(meci.getGazde());
        //meciToCreate.setOaspeti(meci.getOaspeti());
        //meciToCreate.setLocatie(meci.getLocatie());
        return meciRepository.save(meciToCreate);
    }

    public Meci getOne(UUID idMeci) {
        return meciRepository.findById(idMeci).orElseThrow(null);
    }

    public Meci update(Meci meciToUpdate) {

        Meci meci = meciRepository.findById(meciToUpdate.getId()).orElse(new Meci());
        meci.setDateMeciului(meciToUpdate.getDateMeciului());
        //meci.setGazde(meciToUpdate.getGazde());
        //meci.setOaspeti(meciToUpdate.getOaspeti());
        //meci.setLocatie(meciToUpdate.getLocatie());
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
