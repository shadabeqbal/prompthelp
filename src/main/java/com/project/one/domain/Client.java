package com.project.one.domain;

import com.project.one.utils.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client")
public class Client {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "email_verified")
    private Boolean emailVerified;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "mobile_verified")
    private Boolean mobileVerified;

    @Column(name = "account_type")
    private AccountType accountType;

    @Column(name = "account_active")
    private Boolean accountActive;

    @Column(name = "date_created")
    private String dateCreated;

    @Column(name = "password")
    private String password;

    @Column(name = "last_updated_at")
    private String lastUpdatedAt;

    public Client(String cid,String name, String email, String password, AccountType accountType,String dateCreated,String lastUpdatedAt){
        this.id = cid;
        this.name = name;
        this.email = email;
        this.password = password;
        this.accountType = accountType;
        this.dateCreated = dateCreated;
        this.lastUpdatedAt = lastUpdatedAt;
    }
}
