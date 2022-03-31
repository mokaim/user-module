package io.github.mokaim.user.service;

import io.github.mokaim.user.repo.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

  @Autowired
  private TestRepository testRepository;

  public String test() {
    return "test success";
  }

}
