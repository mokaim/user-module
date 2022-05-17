package io.github.mokaim.user.service.auth;

import io.github.mokaim.user.repo.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public abstract class AuthService {
  public abstract String auth(String username);
}
