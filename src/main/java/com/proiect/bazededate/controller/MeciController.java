package com.proiect.bazededate.controller;

import com.proiect.bazededate.models.Meci;
import com.proiect.bazededate.service.MeciService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/meci")
public class MeciController {
    private final MeciService meciService;

    @PostMapping
    public Meci create(@RequestBody Meci meci) throws Exception {
        return meciService.create(meci);
    }

    @GetMapping("/{idMeci}")
    public Meci getOne(@PathVariable String idMeci) {
        return meciService.getOne(UUID.fromString(idMeci));
    }

    @PutMapping
    public Meci update(@RequestBody Meci meciToUpdate) throws Exception {
        return meciService.update(meciToUpdate);
    }

    @DeleteMapping("/{idMeci}")
    public void delete(@PathVariable UUID idMeci) throws Exception {
        meciService.delete(idMeci);
    }
}
