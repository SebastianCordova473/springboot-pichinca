package com.pichinca.ecu.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pichinca.ecu.app.model.Client;
import com.pichinca.ecu.app.repository.IClientDAO;

@Service
@Transactional
public class ClientService implements IClientService {

  /**
   *
   */
  private static final String OPERACION_NO_PERMITIDA = "Operación no permitida";

  @Autowired
  private IClientDAO dao;

  @Override
  public List<Client> getAllClients() {
    throw new UnsupportedOperationException(OPERACION_NO_PERMITIDA);
  }

  @Override
  public Client getClientById(long userId) {
    throw new UnsupportedOperationException(OPERACION_NO_PERMITIDA);
  }

  @Override
  public boolean addClient(Client client) {
    boolean result = true;

    if (dao.clientExists(client.getPerson().getCitizenId())) {
      result = false;
    } else {
      dao.addClient(client);
      result = true;
    }
    return result;
  }

  @Override
  public void updateClient(Client client) {
    throw new UnsupportedOperationException(OPERACION_NO_PERMITIDA);
  }

  @Override
  public void deleteClient(int clientId) {
    throw new UnsupportedOperationException(OPERACION_NO_PERMITIDA);
  }

}
