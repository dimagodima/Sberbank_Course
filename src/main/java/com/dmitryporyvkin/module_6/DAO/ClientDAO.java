package com.dmitryporyvkin.module_6.DAO;


import com.dmitryporyvkin.module_6.entities.Clients;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ClientDAO {

    @PersistenceContext
    EntityManager em;

    public void removeClientByName(String name){
        em.createQuery("delete from Clients c " + "where c.name=:name")
                .setParameter("name",name)
                .executeUpdate();
    }

    public void updateClient(Clients clients){
        em.merge(clients);
    }

}

