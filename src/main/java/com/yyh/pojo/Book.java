package com.yyh.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;

//图书类
@Data
public class Book {
    @Id
    private String id;
    private String bookId;
    private String bookName;
    private String author;
    private Double price;
}
