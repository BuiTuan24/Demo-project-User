package net.project.quanliuser.Infrastructure.repository;

import net.project.quanliuser.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <UserEntity, String> {
}
