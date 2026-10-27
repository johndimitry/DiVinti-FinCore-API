package com.divinti.fincore.domain.model;

import jakarta.persistence.*;

@Entity
public class DiVintiClient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private String fullName;
    @Column(unique = true) private String cpf;
    private String phone;
    @OneToOne private DiVintiUser user;
    private boolean active = true;

    public DiVintiClient(){}
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getFullName(){return fullName;} public void setFullName(String s){this.fullName=s;}
    public String getCpf(){return cpf;} public void setCpf(String s){this.cpf=s;}
    public String getPhone(){return phone;} public void setPhone(String s){this.phone=s;}
    public DiVintiUser getUser(){return user;} public void setUser(DiVintiUser u){this.user=u;}
    public boolean isActive(){return active;} public void setActive(boolean a){this.active=a;}
}