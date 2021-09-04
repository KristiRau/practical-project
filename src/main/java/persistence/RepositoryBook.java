package persistence;

import model.Book;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class RepositoryBook {

    private Connection connection;
    PreparedStatement pstmt;
    ResultSet resultSet;

    public RepositoryBook() {
        connection = DBUtil.getDBConnection();
    }

    public List<Book> listAllBooks() {
        List<Book> bookList = new ArrayList<Book>();
        String sql = "SELECT * FROM book";
        try {
            pstmt = DBUtil.getDBConnection().prepareStatement(sql);
            ResultSet resultSet = pstmt.executeQuery();

            while(resultSet.next()) {
                Book book = new Book();
                book.setBookId(resultSet.getInt(1));
                book.setName(resultSet.getString("name"));
                book.setAuthor(resultSet.getString("author"));
                book.setPublishingYear(resultSet.getInt("publishing_year"));
                book.setCategoryId(resultSet.getInt("category_id"));
                book.setDescription(resultSet.getString("description"));
                bookList.add(book);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bookList;
    }

    public Book findById(int bookId) {
        String sql = "SELECT * FROM book WHERE book_id = ?";
        Book book = null;
        try {
            pstmt = DBUtil.getDBConnection().prepareStatement(sql);
            pstmt.setInt(1, bookId);
            ResultSet resultSet = pstmt.executeQuery();

            while(resultSet.next()) {
                book = new Book();
                book.setName(resultSet.getString("name"));
                book.setAuthor(resultSet.getString("author"));
                book.setPublishingYear(resultSet.getInt("publishing_year"));
                book.setCategoryId(resultSet.getInt("category_id"));
                book.setDescription(resultSet.getString("description"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return book;
    }

}
