package com.pichinca.ecu.app.service;

import java.util.List;

import com.pichinca.ecu.app.model.Client;

public interface IClientService {

  List<Client> getAllClients();

  Client getClientById(long clientId);

  boolean addClient(Client client);

  void updateClient(Client client);

  void deleteClient(int clientId);
}
