package io.github.mokaim.user.service.auth;


import io.github.mokaim.user.repo.auth.UsersRepository;

public abstract class AuthService {

  private UsersRepository usersRepository;

  public abstract String auth(String authKey);

  public String auth(String username, String password) {

    return username + password;
  }

  public AuthService(UsersRepository usersRepository) {
    this.usersRepository = usersRepository;
  }
}
