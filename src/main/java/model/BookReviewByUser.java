package model;

import lombok.Data;

@Data
public class BookReviewByUser {

    private int userReviewId;
    private String bookName;
    private String categoryName;
    private int year;
    private int score;

}
