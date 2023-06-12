package com.proiect.bazededate.controller;

import com.proiect.bazededate.models.Echipa;
import com.proiect.bazededate.service.EchipaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/echipa")
public class EchipaController {

    private final EchipaService echipaService;

    @PostMapping
    public Echipa create(@RequestBody Echipa echipa) {
        return echipaService.create(echipa);
    }

    @GetMapping("/{idEchipa}")
    public Echipa getOne(@PathVariable String idEchipa) {
        return echipaService.getOne(UUID.fromString(idEchipa));
    }

    @PutMapping
    public Echipa update(@RequestBody Echipa echipaToUpdate) {
        return echipaService.update(echipaToUpdate);
    }

    @DeleteMapping("/{idEchipa}")
    public void delete(@PathVariable UUID idEchipa) throws Exception {
        echipaService.delete(idEchipa);
    }


}
