package io.github.mokaim.user.repo.auth.redis;

import io.github.mokaim.user.repo.auth.redis.vo.RedisUser;
import org.springframework.data.repository.CrudRepository;

public interface RedisAuthRepository extends CrudRepository<RedisUser, String>{

}
