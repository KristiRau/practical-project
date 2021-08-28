package menu;

import java.util.List;
import java.util.Scanner;
import model.Customer;
import persistence.RepositoryCustomer;

public class MenuCustomer {
    RepositoryCustomer repositoryCustomer = new RepositoryCustomer();

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: List all customers");
        System.out.println("2: Update account status");
        System.out.println("3: List total active customers");
        System.out.println("4: List total active and not active customers");
        System.out.println("5: Update customers phone number by customer id");
        System.out.println("100 - Return to Main Menu");
        System.out.println("\n/***************************************************/");
        return input.nextInt();
    }

    protected void menuChoice(Scanner input) {

        int userChoice;
        do {
            userChoice = menuOptions(input);
            switch (userChoice) {
                case 1:
                    menuListAllCustomers(input);
                    break;
//                case 2:
//                    menuUpdateAccountStatus(input);
//                    break;
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
            }// End of switch statement
        } while (userChoice != 100);
    }



    private void menuListAllCustomers(Scanner input) {
        List<Customer> listCustomer = repositoryCustomer.listAllCustomers();

        if (listCustomer.size() > 0) {
            System.out.println("\nList of Customers:");
            for (Customer cust : listCustomer) {
                System.out.println(cust.toString());
            }
        } else {
            System.out.println("\nNo customers registered\n");
            menuOptions(input);
        }
    }

//    private void menuUpdateAccountStatus(Scanner input) {
//        System.out.println("Type the customer ID");
//        int id = input.nextInt();
//        Customer result = repositoryCustomer.findCustomerById(id);
//        if (result == null) {
//            System.out.println("\nCustomer not found\n");
//            menuOptions(input);
//        } else {
//            System.out.println("Type the new stock value");
//            int stock = input.nextInt();
//            repositoryCustomer.updateStockProduct(id, stock);
//        }
//    }
//
//    private void menuListActiveCustomers() {
//         System.out.println("Total: " + repositoryCustomer.getTotalCustomerActives());
//    }
//
//    private void menuListActiveAndNotActiveCustomers() {
//        List<Object[]> obj = repositoryCustomer.getTotalCustomerActivesAndNotActives();
//        Object result[] = obj.get(0);
//            System.out.println("Total customers active: " + result[0] +" "+ result[1]);
//            //System.out.println("Total customers not active: " + obj[1]);
//    }
//
//    private void menuUpdatePhoneNumberByCustomerId(Scanner scanner) {
//        System.out.println("User id: ");
//        int id = scanner.nextInt();
//        Customer result = repositoryCustomer.findCustomerById(id);
//
//        if (result != null) {
//            System.out.println("New phone number: ");
//            String phoneNumber = scanner.next();
//            repositoryCustomer.updatePhoneNumberByCustomerId(id, phoneNumber);
//
//        } else {
//            System.out.println("User not found");
//            menuOptions(scanner);
//        }
//    }
}
