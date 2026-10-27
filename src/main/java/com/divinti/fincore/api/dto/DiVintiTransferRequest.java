package com.divinti.fincore.api.dto;

import java.math.BigDecimal;

public class DiVintiTransferRequest {
    private String fromAccountNumber;
    private String toAccountNumber;
    private BigDecimal amount;
    private String description;

    public DiVintiTransferRequest(){}
    public String getFromAccountNumber(){return fromAccountNumber;}
    public void setFromAccountNumber(String s){this.fromAccountNumber=s;}
    public String getToAccountNumber(){return toAccountNumber;}
    public void setToAccountNumber(String s){this.toAccountNumber=s;}
    public BigDecimal getAmount(){return amount;}
    public void setAmount(BigDecimal a){this.amount=a;}
    public String getDescription(){return description;}
    public void setDescription(String d){this.description=d;}
}