package com.proiect.bazededate.service;

import com.proiect.bazededate.models.Clasament;
import com.proiect.bazededate.repository.ClasamentRepository;
import com.proiect.bazededate.repository.EchipaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClasamentService {
    private final ClasamentRepository clasamentRepository;
    private final EchipaRepository echipaRepository;

    public Clasament create(Clasament clasament) {
        Clasament clasamentToCreate = new Clasament();
        clasamentToCreate.setEchipa(echipaRepository.findById(clasament.getEchipa().getId()).orElse(null));


        clasamentToCreate.setPuncte(clasament.getPuncte());
        clasamentToCreate.setVictorii(clasament.getVictorii());
        clasamentToCreate.setEgaluri(clasament.getEgaluri());
        clasamentToCreate.setInfrangeri(clasament.getInfrangeri());
        clasamentToCreate.setLocInClasament(clasament.getLocInClasament());
        return clasamentRepository.save(clasamentToCreate);
    }

    public Clasament getOne(UUID idClasament) {
        return clasamentRepository.findById(idClasament).orElseThrow(null);
    }

    public List<Clasament> getAll() {
        List<Clasament> clasamentTotal = clasamentRepository.findAll();
        clasamentTotal.sort(Comparator.comparing(Clasament::getLocInClasament));
        return clasamentTotal;
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
