package com.proiect.bazededate.service;

import com.proiect.bazededate.models.Echipa;
import com.proiect.bazededate.repository.EchipaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EchipaService {

    private final EchipaRepository echipaRepository;

    public Echipa create(Echipa echipa) {
        Echipa echipaToCreate = new Echipa();
        echipaToCreate.setAndrenor(echipa.getAndrenor());
        echipaToCreate.setEmail(echipa.getEmail());
        echipaToCreate.setTelefon(echipa.getTelefon());
        return echipaRepository.save(echipaToCreate);
    }

    public Echipa getOne(UUID idEchipa) {
        return echipaRepository.findById(idEchipa).orElseThrow(null);
    }

    public Echipa update(Echipa echipaToUpdate) {

        Echipa echipa = echipaRepository.findById(echipaToUpdate.getId()).orElse(new Echipa());
        echipa.setTelefon(echipaToUpdate.getTelefon());
        echipa.setAndrenor(echipaToUpdate.getAndrenor());
        echipa.setEmail(echipaToUpdate.getEmail());
        return echipaRepository.save(echipa);
    }

    public void delete(UUID idEchipa) throws Exception {
        Echipa echipa = echipaRepository.findById(idEchipa).orElse(null);
        if (Objects.equals(null, echipa)) {
            throw new Exception("Entity not found");
        }

        echipaRepository.delete(echipa);
    }
}
