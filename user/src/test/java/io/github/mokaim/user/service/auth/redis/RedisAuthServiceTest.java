package io.github.mokaim.user.service.auth.redis;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

class RedisAuthServiceTest {

  @Test
  void randomStr() {
    String randomStr = RandomStringUtils.random(50, true, false);
    assertNotNull(randomStr);
    System.out.println("randomStr : " + randomStr);
  }
}