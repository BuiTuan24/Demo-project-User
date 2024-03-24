package net.project.quanliuser.application.service;



import net.project.quanliuser.application.dto.request.UserDto;

import java.util.List;

public interface UserService {


    UserDto createUserEntity(UserDto userDto);

    UserDto getUserEntityById(String id);

    UserDto updateUserEntity(String id, UserDto updatedUserDto);

    List<UserDto> getAllUser();

    void deleteUser(String id);

}
