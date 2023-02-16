import java.awt.*;
import java.util.HashMap;
import java.util.Scanner;

import static java.awt.SystemColor.menu;
public class Main {

    static Scanner scanner = new Scanner(System.in);

    static Fruits fruits = new Fruits();
    static HashMap<String, Discount> mapDF = fruits.getMapDiscountFruits();

    public static void main(String[] args) {

        Main app = new Main();
        app(menu);


    }//main
    private static void app(SystemColor menu) {
        //menu
        boolean flag = true;
        do {
            System.out.println("1 -> Enter a new fruit");
            System.out.println("2 -> Enter discount for a fruit (integer number)");
            System.out.println("3 -> Display fruits with discount");
            System.out.println("4 -> Display all available fruits and prices");
            System.out.println("0 -> Exit");
            String scelta = "";
            scelta = scanner.next();

            switch (scelta) {
                case "1":
                    fruits.insertValues();
                    break;
                case "2":
                    fruits.setMapDiscountFruits();
                    break;
                case "3":
                    fruits.displayDiscountFruits(mapDF);
                    break;
                case "4":
                    fruits.displayAllFruits(mapDF);
                    break;
                case "0":
                    System.out.println("The program is closed");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Error, enter a value again");
            }
        } while (flag);
    }
}//Main



