package io.github.mokaim.user.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
로그인, 회원가입
 */
public class AuthVo {

  /*
  회원가입
   */
  @Getter
  @AllArgsConstructor
  @NoArgsConstructor
  public static class SignUpParam {
    private String email;
    private String phone;
    private String password;
  }

  /*
  첫번째 로그인
   */
  @Getter
  @AllArgsConstructor
  @NoArgsConstructor
  public static class FirstLoginParam {
    private String email;
    private String password;
  }

  /*
  두번째 로그인
   */
  @Getter
  @AllArgsConstructor
  @NoArgsConstructor
  public static class SecondLoginParam {
    private String authKey;
  }
}
