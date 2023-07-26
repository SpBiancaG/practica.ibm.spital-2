package com.ibm.practica.spital.repository;

import com.ibm.practica.spital.entity.Pacient;
import com.ibm.practica.spital.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,String> {

    public List<Reservation> findAllReservationsByPacientID(String pacientID);

    @Query(value = "SELECT * FROM reservation WHERE pacient_ID = ?1 ", nativeQuery = true)
    public List<Reservation> findAllByPacientID(String pacientID);
}
