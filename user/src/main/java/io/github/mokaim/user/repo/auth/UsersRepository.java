package io.github.mokaim.user.repo.auth;

import io.github.mokaim.common.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {

}
