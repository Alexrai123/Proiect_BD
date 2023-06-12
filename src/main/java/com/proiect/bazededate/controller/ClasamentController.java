package com.proiect.bazededate.controller;

import com.proiect.bazededate.models.Clasament;
import com.proiect.bazededate.service.ClasamentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clasament")
public class ClasamentController {
    private final ClasamentService clasamentService;

    @PostMapping
    public Clasament create(@RequestBody Clasament clasament) {
        return clasamentService.create(clasament);
    }

    @GetMapping("/{idClasament}")
    public Clasament getOne(@PathVariable String idClasament) {
        return clasamentService.getOne(UUID.fromString(idClasament));
    }

    @PutMapping
    public Clasament update(@RequestBody Clasament clasamentToUpdate) {
        return clasamentService.update(clasamentToUpdate);
    }

    @DeleteMapping("/{idClasament}")
    public void delete(@PathVariable UUID idClasament) throws Exception {
        clasamentService.delete(idClasament);
    }
}
