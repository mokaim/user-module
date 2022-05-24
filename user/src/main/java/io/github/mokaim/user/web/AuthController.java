package io.github.mokaim.user.web;

import io.github.mokaim.common.Response;
import io.github.mokaim.common.entity.Users;
import io.github.mokaim.user.repo.auth.redis.RedisAuthRepository;
import io.github.mokaim.user.repo.auth.redis.vo.RedisUser;
import io.github.mokaim.user.service.auth.AuthService;
import io.github.mokaim.user.service.auth.AuthServiceFactory;
import io.github.mokaim.user.service.auth.redis.RedisAuthService;
import io.github.mokaim.user.vo.AuthVo;
import io.github.mokaim.user.vo.AuthVo.SecondLoginParam;
import java.util.Locale;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

  private final Response response;
  private final AuthServiceFactory authServiceFactory;
  private final RedisAuthService redisAuthService;


  @Transactional
  @PostMapping("/login")
  public ResponseEntity<?> firstLogin(@Validated AuthVo.FirstLoginParam firstLoginParam, BindingResult bindingResult) {
    AuthService authService = authServiceFactory.createAuthService(null);
    String email = firstLoginParam.getEmail();
    String password = firstLoginParam.getPassword();
    Users user = authService.auth(email, password);
    if (user == null) {
      return response.failed("failed.login");
    }

    RedisUser redisUser = redisAuthService.save(user.getIdx());
    String authType = user.getAuthType();
    String authKey = redisUser.getId();

    //return response.success("test", new String[]{"firt","second","third"}, locale);
    return response.success(AuthVo.FirstLoginRes.builder()
        .authType(authType)
        .authKey(authKey)
        .build());
  }

  @Transactional
  @PostMapping("/login/{authType}")
  public ResponseEntity<?> secondLogin(@PathVariable String authType, @Validated SecondLoginParam secondLoginParam,
      BindingResult bindingResult) {
    AuthService authService = authServiceFactory.createAuthService(authType);
    if (authService == null) {
      return response.failed("failed.auth.support");
    }

    String authKey = secondLoginParam.getAuthKey();
    Users user = authService.auth(authKey);
    if (user == null) {
      return response.failed("failed.auth.userInfo");
    }

    return response.success("success");
  }
}
