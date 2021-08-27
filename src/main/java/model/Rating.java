package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Rating {

    private int ratingId;
    private int bookId;
    private int userId;
    private int score;
    private String comment;


}
