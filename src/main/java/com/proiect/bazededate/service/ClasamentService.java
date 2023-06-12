package com.proiect.bazededate.service;

import com.proiect.bazededate.models.Clasament;
import com.proiect.bazededate.repository.ClasamentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClasamentService {
    private final ClasamentRepository clasamentRepository;

    public Clasament create(Clasament clasament) {
        Clasament clasamentToCreate = new Clasament();
        //aici iara cheie straina plm: cred ? clasamentToCreate.setId(clasament.getId());
        clasamentToCreate.setPuncte(clasament.getPuncte());
        clasamentToCreate.setVictorii(clasament.getVictorii());
        clasamentToCreate.setEgaluri(clasament.getEgaluri());
        clasamentToCreate.setInfrangeri(clasament.getInfrangeri());
        return clasamentRepository.save(clasamentToCreate);
    }

    public Clasament getOne(UUID idClasament) {
        return clasamentRepository.findById(idClasament).orElseThrow(null);
    }

    public Clasament update(Clasament clasamentToUpdate) {

        Clasament clasament = clasamentRepository.findById(clasamentToUpdate.getId()).orElse(new Clasament());
        clasamentToUpdate.setPuncte(clasament.getPuncte());
        clasamentToUpdate.setVictorii(clasament.getVictorii());
        clasamentToUpdate.setEgaluri(clasament.getEgaluri());
        clasamentToUpdate.setInfrangeri(clasament.getInfrangeri());
        return clasamentRepository.save(clasament);
    }

    public void delete(UUID idClasament) throws Exception {
        Clasament clasament = clasamentRepository.findById(idClasament).orElse(null);
        if (Objects.equals(null, clasament)) {
            throw new Exception("Entity not found");
        }

        clasamentRepository.delete(clasament);
    }
}
