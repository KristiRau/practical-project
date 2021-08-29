package menu;

import model.BookReviewByUser;
import persistence.RepositoryUserReview;

import java.util.List;
import java.util.Scanner;

public class MenuUserReview {

    RepositoryUserReview repositoryUserReview = new RepositoryUserReview();

    private int menuOptions(Scanner input) {
        System.out.println("\n====================================================");
        System.out.println("Select the submenu option: ");
        System.out.println();
        System.out.println("1: Reviews by user");
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
                    menuReviewsByUser(input);
                    break;
                case 2:
                    //menuUpdateUserEmail(input);
                    break;
//                case 3:
//                    menuListActiveCustomers();
//                    break;
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


}
