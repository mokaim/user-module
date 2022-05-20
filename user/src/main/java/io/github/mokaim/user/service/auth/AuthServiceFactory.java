package io.github.mokaim.user.service.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceFactory {

  private final DefaultAuthService defaultAuthService;
  private final OtpAuthService otpAuthService;
  private final PhoneAuthService phoneAuthService;
  private final PinAuthService pinAuthService;

  public AuthService createAuthService(String authType) {
    if ("pin".equals(authType)) {
      return pinAuthService;
    } else if ("phone".equals(authType)) {
      return phoneAuthService;
    } else if ("otp".equals(authType)) {
      return otpAuthService;
    }
    return defaultAuthService;
  }


}
