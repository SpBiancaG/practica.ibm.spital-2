package com.ibm.practica.spital.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="pacient")
public class Pacient {

    @Id
    @NotNull
    @Column(name="pacient_id")
    private String pacientID;

    @NotNull
    @Column(name="first_name")
    private String firstName;
    @NotNull
    @Column(name="last_name")
    private String lastName;
    @NotNull
    @Column(name="age")
    private int age;
    @NotNull
    @Column(name="issue")
    private String issue;
    @NotNull
    @Column(name="CNP")
    private String cnp;

}
