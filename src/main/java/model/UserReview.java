package model;

import lombok.Data;

@Data
public class UserReview {

    private int userReviewId;
    private int userId;
    private int currentBookId;
    private int ratingScore;
    private String ratingComment;


}
