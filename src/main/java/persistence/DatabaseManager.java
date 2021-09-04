package persistence;



import util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseManager {


    private Connection connection;

    public DatabaseManager() {
        DBUtil.createDatabase();
        connection = DBUtil.getDBConnection();
    }


    private void createTableUserReview() {
        String sql = "CREATE TABLE IF NOT EXISTS user_review (\n"
                + "	user_review_id int NOT NULL AUTO_INCREMENT,\n"
                + "	user_id INT NOT NULL,\n"
                + "	book_id INT NOT NULL,\n"
                + "	number_of_ratings INT DEFAULT NULL,\n"
                + " CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES user(user_id),\n"
                + " CONSTRAINT current_book_fk FOREIGN KEY (book_id) REFERENCES book(book_id),\n"
                + "	 PRIMARY KEY (user_review_id)\n"
                + ");";

        try {
            Statement stmt = connection.createStatement();
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createTableBook() {
        String sql = "CREATE TABLE IF NOT EXISTS book (\n"
                + "	book_id int NOT NULL AUTO_INCREMENT,\n"
                + "	name VARCHAR(45) NOT NULL,\n"
                + "	author varchar(45) NOT NULL,\n"
                + "	publishing_year int NOT NULL,\n"
                + "	category_id int NOT NULL,\n"
                + "	description VARCHAR(250) DEFAULT NULL,\n"
                + " CONSTRAINT category_fk FOREIGN KEY (category_id) REFERENCES category(category_id),\n"
                + "	 PRIMARY KEY (book_id)\n"
                + ");";

        try {
            Statement stmt = connection.createStatement();
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createTableCategory(){
        String sql = "CREATE TABLE IF NOT EXISTS category (\n"
                + "	category_id int NOT NULL AUTO_INCREMENT,\n"
                + "	category_name VARCHAR(45) NOT NULL,\n"
                + "	 PRIMARY KEY (category_id)\n"
                + ");";

        try {
            Statement stmt = connection.createStatement();
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createTableUser() {
        String sql = "CREATE TABLE IF NOT EXISTS user (\n"
                + "	user_id int NOT NULL AUTO_INCREMENT,\n"
                + "	username VARCHAR(45) NOT NULL,\n"
                + "	password varchar(45) NOT NULL,\n"
                + "	first_name varchar(45) DEFAULT NULL,\n"
                + "	last_name varchar(45) DEFAULT NULL,\n"
                + "	date_of_birth DATETIME DEFAULT NULL,\n"
                + "	email varchar(45) NOT NULL,\n"
                + "	 PRIMARY KEY (user_id)\n"
                + ");";

        try {
            Statement stmt = connection.createStatement();
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    private void createTableCustomer() {
        String sql = "CREATE TABLE IF NOT EXISTS customer (\n"
                + "	customer_id int NOT NULL AUTO_INCREMENT,\n"
                        + "	account_status int DEFAULT NULL,\n"
                        + "	email varchar(255) DEFAULT NULL,\n"
                        + "	first_name varchar(255) DEFAULT NULL,\n"
                        + "	last_name varchar(255) DEFAULT NULL,\n"
                        + "	middle_name varchar(255) DEFAULT NULL,\n"
                        + "	password varchar(255) DEFAULT NULL,\n"
                        + "	phone_number varchar(255) DEFAULT NULL,\n"
                        + "	profile_image varchar(255) DEFAULT NULL,\n"
                        + "	username varchar(255) DEFAULT NULL,\n"
                        + "	 PRIMARY KEY (customer_id)\n"
                + ");";
        
        try {
             Statement stmt = connection.createStatement();
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void initTables() {
        createTableCustomer();
        createTableUser();
        createTableCategory();
        createTableBook();
        createTableUserReview();
    }
}
