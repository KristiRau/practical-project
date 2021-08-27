package model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Book {

    private int bookId;
    private String name;
    private String author;
    private int publishingYear;
    private int categoryId;
    private String description;

}
