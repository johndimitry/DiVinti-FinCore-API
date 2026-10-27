package com.divinti.fincore.api.dto;

import java.time.LocalDate;

import com.divinti.fincore.domain.enums.DiVintiTransactionType;

public class DiVintiStatementFilter {
    private String accountNumber;
    private LocalDate startDate;
    private LocalDate endDate;
    private DiVintiTransactionType type;

    public DiVintiStatementFilter(){}
    public String getAccountNumber(){return accountNumber;}
    public void setAccountNumber(String a){this.accountNumber=a;}
    public LocalDate getStartDate(){return startDate;}
    public void setStartDate(LocalDate d){this.startDate=d;}
    public LocalDate getEndDate(){return endDate;}
    public void setEndDate(LocalDate d){this.endDate=d;}
    public DiVintiTransactionType getType(){return type;}
    public void setType(DiVintiTransactionType t){this.type=t;}
}