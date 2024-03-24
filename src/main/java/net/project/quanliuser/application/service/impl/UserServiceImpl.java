package net.project.quanliuser.application.service.impl;


import net.project.quanliuser.application.dto.request.UserDto;
import net.project.quanliuser.domain.entity.UserEntity;
import net.project.quanliuser.application.mapper.UserMapper;
import net.project.quanliuser.Infrastructure.repository.UserRepository;
import net.project.quanliuser.application.service.UserService;
import org.springframework.stereotype.Service;
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
    public UserDto getUserEntityById(String id) {

        UserEntity userEntity = userRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("User khong ton tai"));
        return UserMapper.mapToUserDto(userEntity);
    }

    @Override
    public UserDto updateUserEntity(String id, UserDto updatedUserDto) {

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
    public void deleteUser(String id) {
        UserEntity userEntity = userRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("User khong ton tai"));

        userRepository.deleteById(id);
    }
}
