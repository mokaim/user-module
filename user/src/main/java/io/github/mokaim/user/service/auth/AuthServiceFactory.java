package io.github.mokaim.user.service.auth;

import io.github.mokaim.user.repo.auth.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceFactory {

  private final BasicAuthService basicAuthService;
  private final OtpAuthService otpAuthService;
  private final PhoneAuthService phoneAuthService;
  private final PinAuthService pinAuthService;

  public AuthService createAuthService(String authType) {
    if ("PIN".equals(authType)) {
      return pinAuthService;
    } else if ("PHONE".equals(authType)) {
      return phoneAuthService;
    } else if ("OTP".equals(authType)) {
      return otpAuthService;
    }
    return basicAuthService;
  }


}
