package com.divinti.fincore.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.divinti.fincore.api.dto.DiVintiTransferRequest;
import com.divinti.fincore.domain.model.DiVintiAccount;
import com.divinti.fincore.domain.model.DiVintiTransaction;
import com.divinti.fincore.service.DiVintiAccountService;
import com.divinti.fincore.service.DiVintiTransferService;

@RestController @RequestMapping("/api/divinti/accounts")
public class DiVintiAccountController {
    private final DiVintiAccountService accountService;
    private final DiVintiTransferService transferService;

    public DiVintiAccountController(DiVintiAccountService accountService, DiVintiTransferService transferService){
        this.accountService=accountService;
        this.transferService=transferService;
    }

    @PostMapping public DiVintiAccount create(@RequestBody DiVintiAccount a){ return accountService.create(a); }
    @GetMapping("/{number}") public DiVintiAccount get(@PathVariable String number){ return accountService.findByNumber(number); }
    @PostMapping("/transfer") public DiVintiTransaction transfer(@RequestBody DiVintiTransferRequest req){ return transferService.transfer(req); }
}