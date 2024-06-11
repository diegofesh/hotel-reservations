package com.dfesh.co.hotelreservations.service;

import com.dfesh.co.hotelreservations.dto.RoomDTO;
import com.dfesh.co.hotelreservations.model.Room;

import java.util.Optional;

public interface RoomService {

    public Optional<RoomDTO> findRoomById(Long id);

    public Room save(Room room);

    public Room update(Long id, Room room);

}
