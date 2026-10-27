package com.divinti.fincore.domain.model;

import com.divinti.fincore.domain.enums.DiVintiAccountStatus;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity @Table(name = "divinti_accounts")
public class DiVintiAccount {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(unique = true) private String accountNumber;
    private BigDecimal balance = BigDecimal.ZERO;
    @Enumerated(EnumType.STRING) private DiVintiAccountStatus status = DiVintiAccountStatus.ACTIVE;
    @ManyToOne private DiVintiClient client;

    public DiVintiAccount(){}
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getAccountNumber(){return accountNumber;} public void setAccountNumber(String s){this.accountNumber=s;}
    public BigDecimal getBalance(){return balance;} public void setBalance(BigDecimal b){this.balance=b;}
    public DiVintiAccountStatus getStatus(){return status;} public void setStatus(DiVintiAccountStatus s){this.status=s;}
    public DiVintiClient getClient(){return client;} public void setClient(DiVintiClient c){this.client=c;}
}