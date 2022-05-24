package io.github.mokaim.user.repo.auth.redis;

import static org.junit.jupiter.api.Assertions.*;

import io.github.mokaim.common.entity.Users;
import io.github.mokaim.user.repo.auth.redis.vo.RedisUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class RedisAuthRepositoryTest {

  @Autowired
  private RedisAuthRepository redisAuthRepository;

  @Test
  void save() {
    Users user = Users.builder()
        .idx(1L)
        .email("test@test.com")
        .password("passowrd")
        .otpKey("otp")
        .phone("+821011112222")
        .pin("pin")
        .authType("phone")
        .build();

    RedisUser redisUser = RedisUser.builder().id("test").user(user).build();

    redisAuthRepository.save(redisUser);
  }

  @Test
  void findById() {
    RedisUser redisUser = redisAuthRepository.findById("test")
        .orElse(RedisUser
            .builder()
            .id(null)
            .build());

    assertNotNull(redisUser.getId());
    assertEquals("test", redisUser.getId());

    Users user = redisUser.getUser();

    assertNotNull(user.getIdx());
    assertEquals(1L, user.getIdx());
    assertEquals("test@test.com", user.getEmail());

  }
}