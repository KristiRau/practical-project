package menu;

import persistence.DatabaseManager;

import java.util.Scanner;

public class MainMenu {
    private static DatabaseManager databaseManager;
    private static SubMenuOptions subMenuOptions;
    private static Scanner input;

    public static void main(String[] args) {
        databaseManager = new DatabaseManager();
        databaseManager.initTables();

        input = new Scanner(System.in);
        subMenuOptions = new SubMenuOptions();
        subMenuOptions.menuChoice(input);
    }

    public static void getMainMenu() {
        subMenuOptions.menuChoice(input);
    }
}
