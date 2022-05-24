package io.github.mokaim.user.service.auth;

import io.github.mokaim.common.entity.Users;
import io.github.mokaim.user.repo.auth.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultAuthService extends AuthService{

  private final UsersRepository usersRepository;

  @Override
  public Users auth(String authKey) {
    return null;
  }

  @Autowired
  public DefaultAuthService(UsersRepository usersRepository) {
    super(usersRepository);
    this.usersRepository = usersRepository;
  }
}
