package net.project.quanliuser.Presentation.Controller;

import net.project.quanliuser.application.dto.request.UserDto;
import org.springframework.http.ResponseEntity;


import java.util.List;

public interface UserControllerInterface {

    ResponseEntity<UserDto> addUserEntity( UserDto userDto);

    ResponseEntity<UserDto> getUserEntityById(String id);

    ResponseEntity<UserDto> updateUser( String id, UserDto updatedUserDto);

    ResponseEntity<List<UserDto>> getAllUser();

    ResponseEntity<String> deleteUser( String id);
}


