package persistence;

import model.BookReviewByUser;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositoryUserReview {

    private Connection connection;
    PreparedStatement pstmt;

    public RepositoryUserReview() {
        connection = DBUtil.getDBConnection();
    }

    public List<BookReviewByUser> listReviewsByUser(int userId) {
        List<BookReviewByUser> ratingList = new ArrayList<BookReviewByUser>();
        String sql = "SELECT user_review.user_review_id, book.name, category.category_name, book.publishing_year," +
                " user_review.rating_score" +
                " FROM user_review" +
                " INNER JOIN book ON book.book_id = user_review.current_book_id" +
                " INNER JOIN category ON category.category_id = book.category_id" +
                " WHERE user_id = ?";
        try {
            pstmt = DBUtil.getDBConnection().prepareStatement(sql);
            pstmt.setInt(1, userId);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                BookReviewByUser review = new BookReviewByUser();
                review.setUserReviewId(resultSet.getInt("user_review.user_review_id"));
                review.setBookName(resultSet.getString("book.name"));
                review.setCategoryName(resultSet.getString("category.category_name"));
                review.setYear(resultSet.getInt("book.publishing_year"));
                review.setScore(resultSet.getInt("user_review.rating_score"));
                ratingList.add(review);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ratingList;
    }

}
