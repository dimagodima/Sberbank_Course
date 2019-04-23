package com.dmitryporyvkin.module_6.entities;

import javax.persistence.*;

@Entity
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;



    @ManyToOne
    private AccountType accountType;


    public Clients(){
    }

    public Clients(String name){
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }


    @Override
    public String toString() {
        return "\n  Clients: "+name;
    }

}

