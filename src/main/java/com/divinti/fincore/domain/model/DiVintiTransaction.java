package com.divinti.fincore.domain.model;

import com.divinti.fincore.domain.enums.DiVintiTransactionType;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class DiVintiTransaction {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @ManyToOne private DiVintiAccount fromAccount;
    @ManyToOne private DiVintiAccount toAccount;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING) private DiVintiTransactionType type;
    private String description;
    private LocalDateTime createdAt = LocalDateTime.now();

    public DiVintiTransaction(){}
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public DiVintiAccount getFromAccount(){return fromAccount;} public void setFromAccount(DiVintiAccount a){this.fromAccount=a;}
    public DiVintiAccount getToAccount(){return toAccount;} public void setToAccount(DiVintiAccount a){this.toAccount=a;}
    public BigDecimal getAmount(){return amount;} public void setAmount(BigDecimal a){this.amount=a;}
    public DiVintiTransactionType getType(){return type;} public void setType(DiVintiTransactionType t){this.type=t;}
    public String getDescription(){return description;} public void setDescription(String d){this.description=d;}
    public LocalDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(LocalDateTime c){this.createdAt=c;}
}