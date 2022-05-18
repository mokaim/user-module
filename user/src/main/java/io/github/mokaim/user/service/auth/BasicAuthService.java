package io.github.mokaim.user.service.auth;

import io.github.mokaim.user.repo.auth.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasicAuthService extends AuthService{

  private final UsersRepository usersRepository;

  @Override
  public String auth(String authKey) {
    return null;
  }

  @Autowired
  public BasicAuthService(UsersRepository usersRepository,
      UsersRepository usersRepository1) {
    super(usersRepository);
    this.usersRepository = usersRepository1;
  }
}
