package io.github.mokaim.user.service.auth.redis;

import io.github.mokaim.common.entity.Users;
import io.github.mokaim.user.repo.auth.redis.RedisAuthRepository;
import io.github.mokaim.user.repo.auth.redis.vo.RedisUser;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisAuthService {
  private final RedisAuthRepository redisAuthRepository;

  public RedisUser save(Long userIdx) {
    RedisUser redisUser = RedisUser.builder()
        .id(RandomStringUtils.random(50, true, false))
        .userIdx(userIdx)
        .build();
    return redisAuthRepository.save(redisUser);
  }

  public RedisUser findById(String id) {
    return redisAuthRepository.findById(id).orElse(null);
  }



}
