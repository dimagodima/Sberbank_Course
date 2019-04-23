package com.dmitryporyvkin.module_6.entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Bank {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;


    @OneToMany(mappedBy = "bank" , cascade = CascadeType.PERSIST)
    private List<AccountType> accountTypes = new ArrayList<>();


    public Bank(){
    }


    public AccountType addAccountType(String name){
        AccountType accountType = new AccountType(name);
        accountTypes.add(accountType);
        accountType.setBank(this);
        return accountType;
    }

    public Bank(String name){
        this.name = name;
    }

    public int getId(){
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

    public List<AccountType> getAccountTypes() {
        return accountTypes;
    }

    public void setAccountTypes(List<AccountType> accountTypes) {
        this.accountTypes = accountTypes;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nBank: ");
        stringBuilder.append(name);
        if(accountTypes != null){
            accountTypes.forEach(stringBuilder::append);
        }
        return stringBuilder.toString();
    }

}
