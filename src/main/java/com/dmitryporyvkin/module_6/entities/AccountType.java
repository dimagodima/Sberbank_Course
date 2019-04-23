package com.dmitryporyvkin.module_6.entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AccountType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    public AccountType(){
    }

    @ManyToOne
    private Bank bank;

    @OneToMany(mappedBy = "accountType", cascade = CascadeType.ALL)
    private List<Clients> clients;


    public AccountType(String name){
        this.name = name;
    }

    public Clients addClients(String name){
        if(clients == null){
            clients = new ArrayList<>();
        }
        Clients client = new Clients(name);
        clients.add(client);
        client.setAccountType(this);
        return client;
    }





    public Bank getBank(){
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
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

    public List<Clients> getClients() {
        return clients;
    }

    public void setClients(List<Clients> clients) {
        this.clients = clients;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n Account Type: ");
        stringBuilder.append(name);
        if(clients != null){
            clients.forEach(stringBuilder::append);
        }
        return stringBuilder.toString();
    }

}

