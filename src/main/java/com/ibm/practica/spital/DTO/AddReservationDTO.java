package com.ibm.practica.spital.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AddReservationDTO {

    @NotNull
    private String pacientID;
    @NotNull
    private String specialization;
}
