package model;

import lombok.Data;

@Data
public class Customer {

    private int customerId;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phoneNumber;
    private String profileImage;
    private String userName;
    private String password;
    private int accountStatus;

}
