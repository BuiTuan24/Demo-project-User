package net.project.quanliuser.repository;

import net.project.quanliuser.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <UserEntity, Long> {
}
