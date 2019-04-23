package com.dmitryporyvkin.module_6.DAO;

import com.dmitryporyvkin.module_6.entities.Bank;
import com.dmitryporyvkin.module_6.entities.Clients;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;



@Repository
@Transactional

public class BankDAO {


    @PersistenceContext
    EntityManager em;



    public void saveBank(Bank bank){
        em.persist(bank);
    }

    public Bank getBank(int id){
        return em.find(Bank.class, id);
    }

    public void printBank(int id){
        Bank bank = em.find(Bank.class, id);
        System.out.println(bank);
    }




}