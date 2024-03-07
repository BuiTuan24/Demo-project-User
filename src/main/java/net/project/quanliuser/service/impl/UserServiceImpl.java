package net.project.quanliuser.service.impl;

import net.project.quanliuser.dto.UserDto;
import net.project.quanliuser.entity.UserEntity;
import net.project.quanliuser.mapper.UserMapper;
import net.project.quanliuser.repository.UserRepository;
import net.project.quanliuser.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUserEntity(UserDto userDto) {
        UserEntity userEntity = UserMapper.mapToUserEntity(userDto);
        UserEntity savedUserEntity = userRepository.save(userEntity);
        return UserMapper.mapToUserDto(savedUserEntity);
    }

    @Override
    public UserDto getUserEntityById(Long id) {

        UserEntity userEntity = userRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("User khong ton tai"));
        return UserMapper.mapToUserDto(userEntity);
    }

    @Override
    public UserDto updateUserEntity(Long id, UserDto updatedUserDto) {

        UserEntity existingUserEntity = userRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("User khong ton tai"));

        existingUserEntity.setUserName(updatedUserDto.getUserName());
        existingUserEntity.setEmail(updatedUserDto.getEmail());

        UserEntity updatedUserEntity = userRepository.save(existingUserEntity);

        return UserMapper.mapToUserDto(updatedUserEntity);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<UserEntity> user = userRepository.findAll();
        return user.stream().map((userEntity) -> UserMapper.mapToUserDto(userEntity))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Long id) {
        UserEntity userEntity = userRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("User khong ton tai"));

        userRepository.deleteById(id);
    }
}
