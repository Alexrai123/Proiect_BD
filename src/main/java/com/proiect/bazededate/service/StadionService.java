package com.proiect.bazededate.service;

import com.proiect.bazededate.models.Stadion;
import com.proiect.bazededate.repository.EchipaRepository;
import com.proiect.bazededate.repository.StadionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StadionService {
    private final StadionRepository stadionRepository;
    private final EchipaRepository echipaRepository;

    public Stadion create(Stadion stadion) {
        Stadion stadionToCreate = new Stadion();
        stadionToCreate.setCapacitate(stadion.getCapacitate());
        stadionToCreate.setAnInfiintare(stadion.getAnInfiintare());
        //cheie straina ca mi-e lene sa mai scriu:stadionToCreate.setEchipa(stadion.getEchipa());
        stadionToCreate.setEchipa(echipaRepository.findById(stadion.getEchipa().getId()).orElse(null));
        return stadionRepository.save(stadionToCreate);
    }

    public Stadion getOne(UUID idStadion) {
        return stadionRepository.findById(idStadion).orElseThrow(null);
    }

    public Stadion update(Stadion stadionToUpdate) {

        Stadion stadion = stadionRepository.findById(stadionToUpdate.getId()).orElse(new Stadion());
        stadion.setCapacitate(stadionToUpdate.getCapacitate());
        stadion.setAnInfiintare(stadionToUpdate.getAnInfiintare());
        stadion.setEchipa(echipaRepository.findById(stadionToUpdate.getEchipa().getId()).orElse(null));
        //cheie straina ca mi-e lene sa mai scriu:stadion.setEchipa(stadionToUpdate.getEchipa());
        return stadionRepository.save(stadion);
    }

    public void delete(UUID idStadion) throws Exception {
        Stadion stadion = stadionRepository.findById(idStadion).orElse(null);
        if (Objects.equals(null, stadion)) {
            throw new Exception("Entity not found");
        }

        stadionRepository.delete(stadion);
    }
}
