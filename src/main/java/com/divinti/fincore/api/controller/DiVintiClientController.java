package com.divinti.fincore.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.divinti.fincore.domain.model.DiVintiClient;
import com.divinti.fincore.domain.repository.DiVintiClientRepository;

@RestController @RequestMapping("/api/divinti/clients")
public class DiVintiClientController {
    private final DiVintiClientRepository repo;
    public DiVintiClientController(DiVintiClientRepository repo){this.repo=repo;}
    
    @PostMapping public DiVintiClient create(@RequestBody DiVintiClient c){ return repo.save(c); }
    @GetMapping public List<DiVintiClient> list(){ return repo.findAll(); }
}