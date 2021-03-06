package com.stockbill;

import java.util.Scanner;

/**
 * class with main method
 * Created by hsenid on 10/17/16.
 */
public class ItemDemo {

        public static void main(String args[]) {

            long code;
            char choice;
            Shop aShop = new Shop();
            //Scanner sc = new Scanner(System.in);

            System.out.println("-----ITEM------");
            mainMethod1(aShop);
            //sc.close();

        }

    public static void mainMethod1(Shop aShop) {
        //char choice;
        char choiceVal;
        do {
            System.out.println("1. Add items to list");
            System.out.println("2. Issue item");
            System.out.println("3. Update item list");
            System.out.println("4. Display item details");
            System.out.println("5. Check price for a item");
            System.out.println("6. Exit");
            System.out.println("Choice:");
            //choice = sc.nextLine().charAt(0);
            choiceVal=scannerMethod();

            switchMethod(aShop, choiceVal);
        } while (choiceVal != '6');
    }

    /**
     *switch statement
     */
    public static void switchMethod(Shop aShop, char choiceVal) {

        switch (choiceVal) {

            case '1':
                aShop.addItem();
                break;

            case '2':
                aShop.issueItem();
                break;

            case '3':
                aShop.updateStock();
                break;

            case '4':
                aShop.display();
                break;

            case '5':
                System.out.println("Price of the Item is:"
                        + aShop.checkPrice(inputCode()));

            case '6':
                System.out.println("Thank you!\n");
                break;

        }


    }

    /**
     * method to invoke scanner
     */
    public static  char scannerMethod(){
        Scanner sc = new Scanner(System.in);
        char choice = sc.nextLine().charAt(0);
        return choice;

    }

    /**
     *method to return Item Code
     */
    public static long inputCode() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Item code:");
            if (sc.hasNextLong()) {
                return sc.nextLong();
            } else {
                System.out.println("Invalid Input");
                return 0;
            }
        }

}
