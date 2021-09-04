package menu;


import model.BookReviewByUser;
import persistence.RepositoryBook;
import persistence.RepositoryUser;
import persistence.RepositoryUserReview;

import java.util.List;
import java.util.Scanner;

public class MenuUserReview {

    RepositoryUserReview repositoryUserReview = new RepositoryUserReview();
    RepositoryUser repositoryUser = new RepositoryUser();
    RepositoryBook repositoryBook = new RepositoryBook();

    private int menuOptions(Scanner input) {
        System.out.println("\n====================================================");
        System.out.println("Select the submenu option: ");
        System.out.println();
        System.out.println("1: Reviews by user");
        System.out.println("2: Total number of reviews by book");
        System.out.println("3: Total number of reviews by user");
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
                    menuReviewsByUser(input);
                    break;
                case 2:
                    menuListBookReviewsById(input);
                    break;
                case 3:
                    menuListUserReviewsById(input);
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

    private void menuReviewsByUser(Scanner input) {
        System.out.print("Enter the user ID: ");
        int userId = input.nextInt();
        List<BookReviewByUser> listReview = repositoryUserReview.listReviewsByUser(userId);
        if (listReview != null && !listReview.isEmpty()) {
            for (BookReviewByUser review : listReview) {

                System.out.println(review.toString());
            }
        } else {
            System.out.println("User has no reviews");
        }
    }

    private void menuListUserReviewsById(Scanner input) {
        System.out.print("Enter user ID to see how many reviews he/she has: ");
        int userId = input.nextInt();
        String user = repositoryUser.findById(userId).getUsername();
        System.out.println("Total number of reviews by '" + user + "': " +
                repositoryUserReview.getTotalReviewsByUserId(userId));
    }

    private void menuListBookReviewsById(Scanner input) {
        System.out.print("Enter book ID to see how many reviews it has: ");
        int bookId = input.nextInt();
        String book = repositoryBook.findById(bookId).getName();
        System.out.println("Total number of reviews for book '" + book + "' is: " +
                repositoryUserReview.getTotalReviewCountByBookName(bookId));
    }


}
