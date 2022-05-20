package io.github.mokaim.user.web;

import io.github.mokaim.common.Response;
import io.github.mokaim.common.entity.Users;
import io.github.mokaim.user.service.auth.AuthService;
import io.github.mokaim.user.service.auth.AuthServiceFactory;
import io.github.mokaim.user.vo.AuthVo;
import java.util.Locale;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

  private final Response response;
  private final AuthServiceFactory authServiceFactory;



  @Transactional
  @PostMapping("/login")
  public ResponseEntity<?> firstLogin(Locale locale, @Validated AuthVo.FirstLoginParam firstLoginParam, BindingResult bindingResult) {
    AuthService authService = authServiceFactory.createAuthService(null);
    String email = firstLoginParam.getEmail();
    String password = firstLoginParam.getPassword();
    Users user = authService.auth(email, password);
    if (user == null) {
      return response.failed("failed.login");
    }


    //return response.success("test", new String[]{"firt","second","third"}, locale);
    return response.success("success",  locale);
  }

  @Transactional
  @PostMapping("/login/{authType}")
  public ResponseEntity<?> secondLogin(Locale locale) {

    //return response.success("test", new String[]{"firt","second","third"}, locale);
    return response.success("success",  locale);
  }
}
