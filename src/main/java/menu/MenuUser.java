package menu;

import model.User;
import persistence.RepositoryUser;

import java.util.List;
import java.util.Scanner;

public class MenuUser {

    RepositoryUser repositoryUser = new RepositoryUser();

    private int menuOptions(Scanner input) {
        System.out.println("\n====================================================");
        System.out.println("Select the submenu option: ");
        System.out.println();
        System.out.println("1: List all users");
        System.out.println("2: Update email");
        System.out.println("3: Add new user");
        System.out.println("4: ");
        System.out.println("5: ");
        System.out.println("100 - Return to Main Menu");
        System.out.println("\n====================================================");
        return input.nextInt();
    }

    protected void menuChoice(Scanner input) {

        int userChoice;
        do {
            userChoice = menuOptions(input);
            switch (userChoice) {
                case 1:
                    menuListAllUsers(input);
                    break;
                case 2:
                    menuUpdateUserEmail(input);
                    break;
                case 3:
                    menuAddNewUser(input);
                    break;
//                case 4:
//                    menuListActiveAndNotActiveCustomers();
//                    break;
//                case 5:
//                    menuUpdatePhoneNumberByCustomerId(input);
//                    break;
                case 100:
                    MainMenu.getMainMenu();
                    break;
                default:
                    System.out.println("\nSorry, please enter valid Option");
                    menuOptions(input);
                    break;
            }
        } while (userChoice != 100);
    }



    private void menuListAllUsers(Scanner input) {
        List<User> listUser = repositoryUser.listAllUsers();
        if (listUser.size() > 0) {
            System.out.println("\nList of Users:");
            for (User user : listUser) {
                System.out.println(user.toString());
            }
        } else {
            System.out.println("\nNo users registered\n");
            menuOptions(input);
        }
    }

    private void menuAddNewUser(Scanner input) {
        System.out.print("Enter username: ");
        String username = input.next();

        System.out.print("Enter password: ");
        String password = input.next();

        System.out.print("Enter first name: ");
        String firstName = input.next();
        while (!firstName.matches("[a-zA-Z ,]+") || (!(firstName.length() > 3) || !(firstName.length() < 20))) {
            System.out.println("Please re-enter first name: ");
            firstName = input.next();
        }

        System.out.print("Enter last name: ");
        String lastName = input.next();
        while (!lastName.matches("[a-zA-Z ,]+") || (!(lastName.length() > 3) || !(lastName.length() < 30))) {
            System.out.println("Please re-enter last name: ");
            lastName = input.next();
        }

        System.out.print("Enter email: ");
        String email = input.next();
        while (!isValid(email)) {
            System.out.println("Please re-enter email: ");
            email = input.next();
        }

        repositoryUser.addUser(username, password, firstName, lastName, email);
    }

    private boolean isValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    private void menuUpdateUserEmail(Scanner input) {
        System.out.println("Type the user ID");
        int id = input.nextInt();
        String name = repositoryUser.findById(id).getFirstName();
        User result = repositoryUser.findById(id);
        if (result == null) {
            System.out.println("\nUser not found\n");
            menuOptions(input);
        } else {
            System.out.println("Type the new email for " + name);
            String newStatus = input.next();
            repositoryUser.updateUserEmail(id, newStatus);
        }
    }

}
