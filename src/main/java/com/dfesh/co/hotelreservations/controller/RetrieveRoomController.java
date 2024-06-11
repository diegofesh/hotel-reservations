package com.dfesh.co.hotelreservations.controller;

import com.dfesh.co.hotelreservations.dto.RoomDTO;
import com.dfesh.co.hotelreservations.exception.BadRequestException;
import com.dfesh.co.hotelreservations.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static com.dfesh.co.hotelreservations.constant.Constant.BASE_URL;

@Slf4j
@RestController
@RequestMapping(BASE_URL)
public class RetrieveRoomController {

    private final RoomService roomService;


    public RetrieveRoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/rooms/{id}")
    public ResponseEntity<?> findRoomById(@PathVariable("id") Long id) {
        validatedRequest(id);
        Optional<RoomDTO> roomOptional = this.roomService.findRoomById(id);
        return roomOptional.map(a -> ResponseEntity.ok().body((Object) a))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room not found with ID: " + id));
    }

    private void validatedRequest(Long id) {
        if (id == null) {
            throw new BadRequestException("Room id can't be null or empty");
        }
    }
}
