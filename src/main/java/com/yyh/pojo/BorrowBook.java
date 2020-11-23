package com.yyh.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

//借书类
@Data
public class BorrowBook {
    @Id
    private String id;
    private String bookId;
    private String bookName;
    private String name;//借阅者名称
    private Date borrowDate;
}
