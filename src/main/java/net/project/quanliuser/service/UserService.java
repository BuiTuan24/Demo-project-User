package net.project.quanliuser.service;

import net.project.quanliuser.dto.UserDto;

import java.util.List;

public interface UserService {


    UserDto createUserEntity(UserDto userDto);

    UserDto getUserEntityById(Long id);

    UserDto updateUserEntity(Long id, UserDto updatedUserDto);

    List<UserDto> getAllUser();

    void deleteUser(Long id);

}
