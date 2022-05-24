package io.github.mokaim.user.service.auth;


import io.github.mokaim.common.entity.Users;
import io.github.mokaim.user.repo.auth.UsersRepository;
import io.github.mokaim.user.repo.auth.redis.vo.RedisUser;
import io.github.mokaim.user.service.auth.redis.RedisAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PinAuthService extends AuthService{

  private final UsersRepository usersRepository;
  private final RedisAuthService redisAuthService;

  @Override
  public Users auth(String authKey) {
    RedisUser redisUser = redisAuthService.findById(authKey);
    if (redisUser == null) {
      return null;
    }

    Long userIdx = redisUser.getUserIdx();
    return usersRepository.findById(userIdx).orElse(null);
  }

  @Autowired
  public PinAuthService(UsersRepository usersRepository, RedisAuthService redisAuthService) {
    super(usersRepository);
    this.usersRepository = usersRepository;
    this.redisAuthService = redisAuthService;
  }
}
