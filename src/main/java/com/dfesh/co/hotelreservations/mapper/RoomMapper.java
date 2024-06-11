package com.dfesh.co.hotelreservations.mapper;

import com.dfesh.co.hotelreservations.dto.RoomDTO;
import com.dfesh.co.hotelreservations.model.Room;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomMapper {

    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

    RoomDTO modelToDto(Room model);

    @InheritInverseConfiguration
    Room dtoToModel(RoomDTO dto);

}
