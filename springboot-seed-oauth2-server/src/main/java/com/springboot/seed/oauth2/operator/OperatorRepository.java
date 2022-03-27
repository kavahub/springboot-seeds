package com.springboot.seed.oauth2.operator;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


/**
 * 用户数据访问接口
 */
@CacheConfig(cacheNames = {"sbs-operators-cache"})
public interface OperatorRepository extends JpaRepository<Operator, String>, JpaSpecificationExecutor<Operator> {
    @Cacheable(unless = "#result == null")
    Operator findByUsernameIgnoreCase(String username);

    @CacheEvict
    void deleteByUsernameIgnoreCase(String username);
    
}
