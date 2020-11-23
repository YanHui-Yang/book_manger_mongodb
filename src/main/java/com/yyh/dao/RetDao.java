package com.yyh.dao;

import com.yyh.pojo.RetBook;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetDao extends MongoRepository<RetBook, String> {
    RetBook findRetBookById(String id);
}
