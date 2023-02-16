import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class Fruits {
    Properties properties = new Properties();
    Scanner scanner = new Scanner(System.in);
    HashMap<String, Discount> mapDiscountFruits = new HashMap<>();

    public HashMap<String, Discount> getMapDiscountFruits() {
        return mapDiscountFruits;
    }

    public void insertValues() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("fruits.properties");
            System.out.println("Enter the name of a new fruit ");
            String k = scanner.next().toLowerCase();
            System.out.println("Enter the price of the fruit (per 1 kg)");
            //  scanner.skip("\n");//alternative->   scanner.nextLine();
            String v = scanner.next();
            System.out.println("You entered: " + k + " " + v);
            properties.setProperty(k, v);
            properties.store(fileOutputStream, "A new fruit was added");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Not possible to write in the file: " + e.getMessage());
        }
    }

    public void setMapDiscountFruits() {
        int discountRate = 0;
        float oldPrice = 0, newPrice = 0;
        String fruitName = "";
        try {
            FileInputStream fileInputStream = new FileInputStream("fruits.properties");
            properties.load(fileInputStream);
            System.out.println("Enter the name of a fruit");
            fruitName = scanner.next().toLowerCase();
            if (properties.getProperty(fruitName) != null) {
                System.out.println("Enter discount rate");
                discountRate = scanner.nextInt();
                String oldPriceStr = properties.getProperty(fruitName);
                oldPrice = Float.parseFloat(oldPriceStr);
                newPrice = oldPrice - (oldPrice * discountRate / 100);
                // insert values into the map
                mapDiscountFruits.put(fruitName, new Discount(discountRate, oldPrice, newPrice));
                System.out.println("You changed properties of " + fruitName.toUpperCase() + ", applying discount: " + discountRate +
                        "% | Old price: " + String.format("%.2f", oldPrice) + "€, new price: " + String.format("%.2f", newPrice) + "€");
            } else {
                System.out.println("The fruit not found");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Can't write in file " + e.getMessage());
        }
    }

    public void displayDiscountFruits(HashMap<String, Discount> mapDiscountFruits) {
        Set<String> keyset = mapDiscountFruits.keySet();
        System.out.println("Available fruits with discount: ");
        for (String element : keyset) {
            System.out.println(element.toUpperCase() + " --> " + mapDiscountFruits.get(element));
        }
    }

    public void displayAllFruits(HashMap<String, Discount> mapDiscountFruits) {
        Set<String> keyset = mapDiscountFruits.keySet();
        System.out.println("Available fruits: ");
        for (String element : keyset) {
            System.out.println(element.toUpperCase() + " --> " + mapDiscountFruits.get(element));
            for (String el : properties.stringPropertyNames()) {
                String tmp = properties.getProperty(el);
                float floatTmp = Float.parseFloat(tmp);
                String formattedTmp = String.format("%.2f", floatTmp);
                if (tmp != null && !(el.toUpperCase().equals(element.toUpperCase()))) {
                    System.out.println(el.toUpperCase() + " --> " + formattedTmp + "€");
                }
            }
        }
    }

}//
