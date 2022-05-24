package io.github.mokaim.user.repo.auth.redis.vo;

import io.github.mokaim.common.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@AllArgsConstructor
@Builder
@RedisHash(value = "user", timeToLive = 180)  //3분
public class RedisUser {
  @Id
  private String id;

  private Long userIdx;
}
