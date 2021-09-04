package persistence;


import model.User;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class RepositoryUser {

    private Connection connection;
    PreparedStatement pstmt;
    Scanner input = new Scanner(System.in);

    public RepositoryUser() {
        connection = DBUtil.getDBConnection();
    }

    public List<User> listAllUsers() {
        List<User> userList = new ArrayList<User>();
        String sql = "SELECT * FROM user";
        try {
            pstmt = DBUtil.getDBConnection().prepareStatement(sql);
            ResultSet resultSet = pstmt.executeQuery();

            while(resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt(1));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setDateOfBirth(resultSet.getDate("date_of_birth"));
                user.setEmail(resultSet.getString("email"));
                userList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    public User findById(int userId) {
        String sql = "SELECT * FROM user WHERE user_id = ?";
        User user = null;
        try {
            pstmt = DBUtil.getDBConnection().prepareStatement(sql);
            pstmt.setInt(1, userId);
            ResultSet resultSet = pstmt.executeQuery();

            while(resultSet.next()) {
                user = new User();
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setDateOfBirth(resultSet.getDate("date_of_birth"));
                user.setEmail(resultSet.getString("email"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    public void updateUserEmail(int userId, String email) {
        String sql = "UPDATE user SET email = ? WHERE user_id = ?";
        try {
            pstmt = DBUtil.getDBConnection().prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setInt(2, userId );
            pstmt.executeUpdate();
            System.out.println("User email updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUser(String username, String password, String firstName, String lastName, Date dateOfBirth, String email) {
        String sql = "INSERT INTO user(username, password, first_name, last_name, date_of_birth, email) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            pstmt = DBUtil.getDBConnection().prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, firstName);
            pstmt.setString(4, lastName);
            pstmt.setDate(5, dateOfBirth);
            pstmt.setString(6, email);
            pstmt.execute();
            System.out.println("User added");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
