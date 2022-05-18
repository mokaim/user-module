package io.github.mokaim.user.service.auth;

import org.springframework.stereotype.Component;

@Component
public class AuthFactory {


  public static AuthService getInstance(String authType) {
    if ("PIN".equals(authType)) {
      return new PinAuthService();
    } else if ("PHONE".equals(authType)) {
      return new PhoneAuthService();
    } else if ("OTP".equals(authType)) {
      return new OtpAuthService();
    } else if ("NONE".equals(authType)) {
      return new BasicAuthService();
    }
    return null;
  }
}
