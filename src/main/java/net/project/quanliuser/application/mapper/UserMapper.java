package net.project.quanliuser.application.mapper;


import net.project.quanliuser.application.dto.request.UserDto;
import net.project.quanliuser.domain.entity.UserEntity;

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
