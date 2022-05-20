package io.github.mokaim.user.repo.auth.redis.vo;

import io.github.mokaim.common.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@AllArgsConstructor
@Builder
@RedisHash
public class RedisUser {
  @Id
  private String id;

  private Users user;
}
