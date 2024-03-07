package net.project.quanliuser.controller;


import net.project.quanliuser.dto.UserDto;
import net.project.quanliuser.service.UserService;
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
    public ResponseEntity<UserDto> addUserEntity(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.createUserEntity(userDto), HttpStatus.CREATED);
    }


    //Get User
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserEntityById(@PathVariable Long id){
        UserDto userDto = userService.getUserEntityById(id);
        return ResponseEntity.ok(userDto);
    }

    //udapte User
    @PutMapping("/{id}/update")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto updatedUserDto) {

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
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok("Thong tin User da xoa thanh cong!");
    }

}

