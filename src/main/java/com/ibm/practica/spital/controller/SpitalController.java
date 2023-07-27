package com.ibm.practica.spital.controller;

import com.ibm.practica.spital.DTO.*;
import com.ibm.practica.spital.service.SpitalService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/spital")
public class SpitalController {

    @Autowired
    private SpitalService service;

    @GetMapping("/getAllPacients")
    public List<PacientDTO> getAllPacients(){
        log.info("SpitalController.getAllPacients() has started...");
        List<PacientDTO> result = service.getAllPacients();

        log.info("SpitalController.getAllPacients() has finished.");
        return result;
    }

    @GetMapping("/reservations")
    public List<ReservationDTO> getReservations(){
        return service.getReservations();
    }

    @GetMapping("/reservation/{reservationID}")
    public ResponseEntity<ReservationDTO> getReservation(@RequestParam String reservationID){
        ReservationDTO result = service.getReservation(reservationID);
        if(ObjectUtils.isEmpty(result)){
            log.info("getReservation() could not find any reservation with ID: " + reservationID);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }
    @GetMapping("/getPacientReservation/{pacientID}")
    public ResponseEntity<List<ReservationDTO>> getReservationForPacient(@RequestParam String pacientID){
        List<ReservationDTO> result = service.getReservationForPacient(pacientID);
        if(ObjectUtils.isEmpty(result)){
            log.info("getPacientReservation() could not find any reservation for pacientID: " + pacientID);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/addReservation")
    public ResponseEntity addReservation(@RequestBody @Valid AddReservationDTO reservation){

        return service.addReservation(reservation) ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }

    @PostMapping("/addPacient")
    public ResponseEntity addPacient(@RequestBody @Valid AddPacientDTO pacient){
        log.info("addPacient() started for : " + pacient);
        return service.addPacient(pacient) ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/deleteReservation/{id}")
    public ResponseEntity deleteReservation(@RequestParam String reservationID){
        service.deleteReservation(reservationID);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deletePacient/{id}")
    public ResponseEntity deletePacient(@RequestParam String pacientID){
        return service.deletePacient(pacientID) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @PostMapping("/editPacient")
    public ResponseEntity editPacient(@RequestBody PacientDTO pacientDTO){
        return service.editPacient(pacientDTO) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }



    //endpoints for doctors
    @GetMapping("/getAllDoctors")
    public List<DoctorDTO> getAllDoctors() {
        log.info("SpitalController.getAllDoctors() has started...");
        List<DoctorDTO> result = service.getAllDoctors();
        log.info("SpitalController.getAllDoctors() has finished.");
        return result;
    }





    @GetMapping("/doctor/{doctorID}")
    public ResponseEntity<DoctorDTO> getDoctor(@RequestParam String doctorID){
        DoctorDTO result = service.getDoctor(doctorID);
        if(ObjectUtils.isEmpty(result)){
            log.info("getReservation() could not find any reservation with ID: " + doctorID);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }
    @PostMapping("/addDoctor")
    public ResponseEntity addDoctor(@RequestBody @Valid AddDoctorDTO doctor) {
        log.info("addDoctor() started for : " + doctor);
        return service.addDoctor( doctor) ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }


    @DeleteMapping("/deleteDoctor")
    public ResponseEntity deleteDoctor(@RequestParam String doctorID) {
        return service.deleteDoctor(doctorID) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }


    @PutMapping("/editDoctor/{doctorID}") // Add the path variable for doctorID
    public ResponseEntity editDoctor(@PathVariable String doctorID, @RequestBody AddDoctorDTO doctorDTO) {
        return service.editDoctor(doctorID, doctorDTO) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }





}
