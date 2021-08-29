package model;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private int userId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String email;


}
