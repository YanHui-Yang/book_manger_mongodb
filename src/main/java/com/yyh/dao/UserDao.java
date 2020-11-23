package com.yyh.dao;

import com.yyh.pojo.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends MongoRepository<User, String> {
    User findByUsername(String username);

    User findUserById(String id);
}
