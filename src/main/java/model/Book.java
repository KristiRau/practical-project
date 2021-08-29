package model;


import lombok.Data;

@Data
public class Book {

    private int bookId;
    private String name;
    private String author;
    private int publishingYear;
    private int categoryId;
    private String description;

}
