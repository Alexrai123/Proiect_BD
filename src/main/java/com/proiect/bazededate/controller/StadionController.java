package com.proiect.bazededate.controller;

import com.proiect.bazededate.models.Stadion;
import com.proiect.bazededate.service.StadionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stadion")
public class StadionController {

    private final StadionService stadionService;

    @PostMapping
    public Stadion create(@RequestBody Stadion stadion) {
        return stadionService.create(stadion);
    }

    @GetMapping("/{idStadion}")
    public Stadion getOne(@PathVariable String idStadion) {
        return stadionService.getOne(UUID.fromString(idStadion));
    }

    @PutMapping
    public Stadion update(@RequestBody Stadion stadionToUpdate) {
        return stadionService.update(stadionToUpdate);
    }

    @DeleteMapping("/{idStadion}")
    public void delete(@PathVariable UUID idStadion) throws Exception {
        stadionService.delete(idStadion);
    }
}
