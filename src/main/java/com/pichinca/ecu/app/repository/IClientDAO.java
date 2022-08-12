package com.pichinca.ecu.app.repository;

import java.util.List;

import com.pichinca.ecu.app.model.Client;

public interface IClientDAO {

  List<Client> getAllClients();

  Client getClientById(long clientId);

  void addClient(Client client);

  void updateClient(Client client);

  void deleteClient(int clientId);

  boolean clientExists(String citizenId);

}
