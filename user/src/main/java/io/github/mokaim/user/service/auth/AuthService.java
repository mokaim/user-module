package io.github.mokaim.user.service.auth;


import io.github.mokaim.common.entity.Users;
import io.github.mokaim.user.repo.auth.UsersRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

public abstract class AuthService {

  private final UsersRepository usersRepository;
  final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

  public abstract Users auth(String authKey);

  @Transactional(readOnly = true)
  public Users auth(String username, String password) {
    Users user = usersRepository.findFirstByEmail(username);
    if (user == null) {
      return null;
    }

    String storedPassword = user.getPassword();
    if (!bCryptPasswordEncoder.matches(password, storedPassword)) {
      return null;
    }
    return user;
  }

  public AuthService(UsersRepository usersRepository) {
    this.usersRepository = usersRepository;
  }
}
