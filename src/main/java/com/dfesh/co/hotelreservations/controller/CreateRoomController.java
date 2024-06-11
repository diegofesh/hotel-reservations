package com.dfesh.co.hotelreservations.controller;

import com.dfesh.co.hotelreservations.dto.RoomDTO;
import com.dfesh.co.hotelreservations.exception.BadRequestException;
import com.dfesh.co.hotelreservations.mapper.RoomMapper;
import com.dfesh.co.hotelreservations.model.Room;
import com.dfesh.co.hotelreservations.service.RoomService;
import com.dfesh.co.hotelreservations.util.RequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.dfesh.co.hotelreservations.constant.Constant.BASE_URL;
import static java.util.Objects.isNull;

@Slf4j
@RestController
@RequestMapping(BASE_URL)
public class CreateRoomController {

    private final RoomService roomService;

    public CreateRoomController(RoomService roomService) {
        this.roomService = roomService;
    }


    @PostMapping("/create")
    public ResponseEntity<RoomDTO> createRoom(@RequestBody RoomDTO roomDTO) {
        RequestUtil.createRequestId();
        log.info("start - create room {}", roomDTO);
        validatedRequest(roomDTO);
        Room model = roomService.save(RoomMapper.INSTANCE.dtoToModel(roomDTO));

        return new ResponseEntity<>(RoomMapper.INSTANCE.modelToDto(model), HttpStatus.CREATED);
    }

    private void validatedRequest(RoomDTO dto) {
        if (dto == null) {
            throw new BadRequestException("Room can't be null or empty");
        }
        if (isNull(dto.getType()) || StringUtils.isEmpty(dto.getType().trim())) {
            throw new BadRequestException("Room type can't be null or empty");
        }
        if (isNull(dto.getPrice())) {
            throw new BadRequestException("Room price can't be null");
        }
    }

}
