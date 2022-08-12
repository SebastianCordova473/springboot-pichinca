package com.pichinca.ecu.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pichinca.ecu.app.model.Client;

@Transactional
@Repository
public class ClientDAO implements IClientDAO {
  static final String OPERACION_NO_PERMITIDA = "Operación no permitida";
  @PersistenceContext
  private EntityManager entityManager;

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public List<Client> getAllClients() {
    throw new UnsupportedOperationException(OPERACION_NO_PERMITIDA);
  }

  @Override
  public Client getClientById(long clientId) {
    throw new UnsupportedOperationException(OPERACION_NO_PERMITIDA);

  }

  @Override
  public void addClient(Client client) {
    entityManager.persist(client);
  }

  @Override
  public void updateClient(Client client) {
    throw new UnsupportedOperationException(OPERACION_NO_PERMITIDA);

  }

  @Override
  public void deleteClient(int clientId) {
    throw new UnsupportedOperationException(OPERACION_NO_PERMITIDA);

  }

  @Override
  public boolean clientExists(String citizenId) {
    String hql = "select p.citizenId FROM Client c inner join c.person p where p.citizenId = ?0";
    Query<String> q = sessionFactory.getCurrentSession().createQuery(hql, String.class);

    int count = q.setParameter(0, citizenId).getResultList().size();
    return count > 0;
  }

}
