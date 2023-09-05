package com.om.redis.repository;

import com.om.redis.entity.Person;
import com.redis.om.spring.repository.RedisDocumentRepository;

public interface PersonRepository extends RedisDocumentRepository<Person,String> {
}
