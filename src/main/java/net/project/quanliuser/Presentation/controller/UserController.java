package net.project.quanliuser.Presentation.controller;

import jakarta.validation.Valid;

import net.project.quanliuser.application.dto.request.UserDto;
import net.project.quanliuser.application.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/username")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    //add User
    @PostMapping
    public ResponseEntity<UserDto> addUserEntity(@Valid @RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.createUserEntity(userDto), HttpStatus.CREATED);
    }


    //Get User
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserEntityById(@Valid @PathVariable String id){
        UserDto userDto = userService.getUserEntityById(id);
        return ResponseEntity.ok(userDto);
    }

    //udapte User
    @PutMapping("/{id}/update")
    public ResponseEntity<UserDto> updateUser(@Valid @PathVariable String id, @RequestBody UserDto updatedUserDto) {

        UserDto updatedUser = userService.updateUserEntity(id, updatedUserDto);
        return ResponseEntity.ok(updatedUser);
    }

    //Get all User
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser(){
        List<UserDto> user =  userService.getAllUser();
        return ResponseEntity.ok(user);
    }

    //Delete Userbyid
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@Valid @PathVariable String id){
        userService.deleteUser(id);
        return ResponseEntity.ok("Thong tin User da xoa thanh cong!");
    }

}


