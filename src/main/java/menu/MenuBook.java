package menu;

import model.Book;
import persistence.RepositoryBook;

import java.util.List;
import java.util.Scanner;

public class MenuBook {

    RepositoryBook repositoryBook = new RepositoryBook();

    private int menuOptions(Scanner input) {
        System.out.println("\n====================================================");
        System.out.println("Select the submenu option: ");
        System.out.println();
        System.out.println("1: List all books");
        System.out.println("2: ");
        System.out.println("3: ");
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
                    menuListAllBooks(input);
                    break;
                case 2:
                    //menuUpdateUserEmail(input);
                    break;
                case 3:
                   // menuAddNewUser(input);
                    break;
                case 4:
                   // menuUserInfoById(input);
                    break;
//                case 5:
//                    menuUpdatePhoneNumberByCustomerId(input);
//                    break;
                case 100:

                    break;
                default:
                    System.out.println("\nSorry, please enter valid Option");
                    menuOptions(input);
                    break;
            }
        } while (userChoice != 100);
    }

    private void menuListAllBooks(Scanner input) {
        List<Book> listBook = repositoryBook.listAllBooks();
        if (listBook.size() > 0) {
            System.out.println("\nList of Books:");
            for (Book book : listBook) {
                System.out.println(book.toString());
            }
        } else {
            System.out.println("\nNo books found\n");
            menuOptions(input);
        }
    }



}
