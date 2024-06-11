package com.dfesh.co.hotelreservations.service.impl;

import com.dfesh.co.hotelreservations.dto.RoomDTO;
import com.dfesh.co.hotelreservations.mapper.RoomMapper;
import com.dfesh.co.hotelreservations.model.Room;
import com.dfesh.co.hotelreservations.repository.RoomRepository;
import com.dfesh.co.hotelreservations.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Transactional
    public Optional<RoomDTO> findRoomById(Long id){
        Optional<Room> roomOptional = this.roomRepository.findById(id);
        return roomOptional.map(a -> RoomMapper.INSTANCE.modelToDto(a));
    }

    @Transactional
    public Room save(Room room) {
        return this.roomRepository.save(room);
    }

    @Transactional
    public Room update(Long id, Room room) {
        return this.roomRepository.findById(id).map(r -> {
            r.setType(room.getType());
            r.setPrice(room.getPrice());
            return this.roomRepository.save(r);
        }).orElseThrow();
    }
}
