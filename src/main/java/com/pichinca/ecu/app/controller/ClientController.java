package com.pichinca.ecu.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pichinca.ecu.app.model.Client;
import com.pichinca.ecu.app.service.IClientService;

@RestController
@RequestMapping(value = "/api")
public class ClientController {

  @Autowired
  private IClientService service;

  @PostMapping(value = "usuario")
  public ResponseEntity<Void> createUser(@RequestBody Client client) {
    boolean flag = service.addClient(client);
    if (!flag) {
      return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
}
