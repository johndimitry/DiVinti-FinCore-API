package com.divinti.fincore.domain.model;

import com.divinti.fincore.domain.enums.DiVintiRole;
import jakarta.persistence.*;

@Entity @Table(name = "divinti_users")
public class DiVintiUser {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(unique = true) private String email;
    private String password;
    @Enumerated(EnumType.STRING) private DiVintiRole role;
    private boolean enabled = true;

    public DiVintiUser(){}
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getEmail(){return email;} public void setEmail(String s){this.email=s;}
    public String getPassword(){return password;} public void setPassword(String s){this.password=s;}
    public DiVintiRole getRole(){return role;} public void setRole(DiVintiRole r){this.role=r;}
    public boolean isEnabled(){return enabled;} public void setEnabled(boolean e){this.enabled=e;}
}