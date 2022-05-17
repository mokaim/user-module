package io.github.mokaim.user.service.auth;

public class AuthFactory {

  public static AuthService getInstance(String authType) {
    if ("PIN".equals(authType)) {
      return new PinAuthService();
    } else if ("PHONE".equals(authType)) {

    } else if ("OTP".equals(authType)) {

    } else if ("NONE".equals(authType)) {

    }
    return null;
  }
}
