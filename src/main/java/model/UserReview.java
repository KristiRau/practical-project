package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserReview {

    private int userReviewId;
    private int userId;
    private int currentBookId;
    private int numberOfRatings;


}
