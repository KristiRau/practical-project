package menu;

import java.util.Scanner;

public class SubMenuOptions {

    private MenuUser menuUser;
    private MenuUserReview menuUserReview;
    private MenuBook menuBook;

    public SubMenuOptions() {
        this.menuUser = new MenuUser();
        this.menuUserReview = new MenuUserReview();
        this.menuBook = new MenuBook();
    }

    private int menuOptions(Scanner input) {
        System.out.println("\n====================================================");
        System.out.println("Select the menu option: ");
        System.out.println();
        System.out.println("1: Sub Menu - User");
        System.out.println("2: Sub Menu - User Review");
        System.out.println("3: Sub Menu - Book");
        System.out.println("4: Sub Menu - <NAME>");
        System.out.println("100 - Quit");
        System.out.println("\n====================================================");

        return input.nextInt();
    }

    public void menuChoice(Scanner input) {

        int userChoice;
        do {
            userChoice = menuOptions(input);
            switch (userChoice) {
                case 1:
                    this.menuUser.menuChoice(input);
                    break;
                case 2:
                    this.menuUserReview.menuChoice(input);
                    break;
                case 3:
                    this.menuBook.menuChoice(input);
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:

                    break;
                case 100:

                    break;
                default:
                    System.out.println("\nSorry, please enter valid Option");
                    menuOptions(input);
                    break;
            }
        } while (userChoice != 100);
        System.out.println("Closing system...");
        System.out.println("Thank you. Good Bye.");
    }




}
