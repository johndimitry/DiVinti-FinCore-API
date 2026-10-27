package com.divinti.fincore.domain.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class DiVintiAuditLog {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String action;
    private String performedBy;
    private String details;
    private LocalDateTime timestamp = LocalDateTime.now();

    public DiVintiAuditLog(){}
    
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getAction(){return action;} public void setAction(String a){this.action=a;}
    public String getPerformedBy(){return performedBy;} public void setPerformedBy(String p){this.performedBy=p;}
    public String getDetails(){return details;} public void setDetails(String d){this.details=d;}
    public LocalDateTime getTimestamp(){return timestamp;} public void setTimestamp(LocalDateTime t){this.timestamp=t;}

    public static Builder builder(){return new Builder();}
    public static class Builder {
        private final DiVintiAuditLog l = new DiVintiAuditLog();
        public Builder action(String a){l.action=a; return this;}
        public Builder performedBy(String p){l.performedBy=p; return this;}
        public Builder details(String d){l.details=d; return this;}
        public DiVintiAuditLog build(){return l;}
    }
}