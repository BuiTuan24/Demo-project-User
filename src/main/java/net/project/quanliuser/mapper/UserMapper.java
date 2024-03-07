package net.project.quanliuser.mapper;

import net.project.quanliuser.dto.UserDto;
import net.project.quanliuser.entity.UserEntity;

import java.util.List;

public class UserMapper {

    public static UserEntity mapToUserEntity(UserDto userDto){
        UserEntity userEntity = new UserEntity(
                userDto.getId(),
                userDto.getUserName(),
                userDto.getEmail()
        );

        return userEntity;
    }

    public static UserDto mapToUserDto(UserEntity userEntity){
        UserDto userDto = new UserDto(
                userEntity.getId(),
                userEntity.getUserName(),
                userEntity.getEmail()
        );

        return userDto;
    }


}
