package com.yyh.dao;

import com.yyh.pojo.BorrowBook;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowDao extends MongoRepository<BorrowBook, String> {
    BorrowBook findBorrowBookById(String id);
}
