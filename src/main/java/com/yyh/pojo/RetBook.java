package com.yyh.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class RetBook {
    @Id
    private String id;
    private String bookId;
    private String bookName;
    private String name;
    private Date retDate;
}
