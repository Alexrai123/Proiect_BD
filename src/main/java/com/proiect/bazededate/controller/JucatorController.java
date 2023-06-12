package com.proiect.bazededate.controller;

import com.proiect.bazededate.models.Echipa;
import com.proiect.bazededate.models.Jucator;
import com.proiect.bazededate.service.EchipaService;
import com.proiect.bazededate.service.JucatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jucator")
public class JucatorController {

    private final JucatorService jucatorService;

    @PostMapping
    public Jucator create(@RequestBody Jucator jucator) {
        return jucatorService.create(jucator);
    }

    @GetMapping("/{idJucator}")
    public Jucator getOne(@PathVariable String idJucator) {
        return jucatorService.getOne(UUID.fromString(idJucator));
    }

    @PutMapping
    public Jucator update(@RequestBody Jucator jucatorToUpdate) {
        return jucatorService.update(jucatorToUpdate);
    }

    @DeleteMapping("/{idJucator}")
    public void delete(@PathVariable UUID idJucator) throws Exception {
        jucatorService.delete(idJucator);
    }
}
