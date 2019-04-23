package com.dmitryporyvkin.module_6;

import com.dmitryporyvkin.module_6.DAO.BankDAO;
import com.dmitryporyvkin.module_6.DAO.ClientDAO;
import com.dmitryporyvkin.module_6.entities.AccountType;
import com.dmitryporyvkin.module_6.entities.Bank;
import com.dmitryporyvkin.module_6.entities.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Dmitry Poryvkin
// dgdwow@yandex.ru

@SpringBootApplication
public class Module6Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Module6Application.class, args);
    }

    

    @Autowired
    BankDAO bankDAO;

    @Autowired
    ClientDAO clientDAO;


    @Override
    public void run(String... args) throws Exception {


        Bank bank = new Bank("VILLAGEBANK");
        AccountType debit = bank.addAccountType("DEBIT");
        AccountType credit = bank.addAccountType("CREDIT");
        Clients client1 = debit.addClients("PETROV");
        Clients client2 = debit.addClients("SIDOROV");
        Clients client3 = credit.addClients("IVANOV");

        bankDAO.saveBank(bank);

        Bank bank1 = bankDAO.getBank(1);

        bankDAO.printBank(1);

        clientDAO.removeClientByName("IVANOV");


    }


}