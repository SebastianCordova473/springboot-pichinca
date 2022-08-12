package com.pichinca.ecu.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@Table(name = "persona")
public class Person implements Serializable {
  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "nombre")
  private String name;

  @Column(name = "genero")
  private String gender;

  @Column(name = "edad")
  private Integer age;

  @Column(name = "estado")
  private Boolean active;

  @Column(name = "direccion")
  private String address;

  @Column(name = "telefono")
  private Integer phone;

  @Column(name = "identificación")
  private String citizenId;

}
