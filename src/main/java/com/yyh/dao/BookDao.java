package com.yyh.dao;

import com.yyh.pojo.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends MongoRepository<Book, String> {
    Book findBookById(String id);
}
