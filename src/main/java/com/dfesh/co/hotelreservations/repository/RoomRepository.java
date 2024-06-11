package com.dfesh.co.hotelreservations.repository;

import com.dfesh.co.hotelreservations.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findAllByType();
}
