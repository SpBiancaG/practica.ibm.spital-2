package com.ibm.practica.spital.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name="reservation")
public class Reservation {

    @Id
    @NotNull
    @Column(name="reservation_id")
    private String id;
    @NotNull
    @Column(name="pacient_id")
    private String pacientID;
    @NotNull
    @Column(name="reservation_date")
    private LocalDateTime reservationDate;
    @NotNull
    @Column(name="specialization")
    private String specialization;
}
