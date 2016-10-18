package com.stockbill;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Shop class with search item(), add item(), display item(), issue item(), check price() methods
 * Created by hsenid on 10/17/16.
 */
public class Shop {

    private ArrayList<Item> ItemList;
    private Scanner sc = new Scanner(System.in);

    public Shop() {
        System.out.println("New Shop for Items created.");
        ItemList = new ArrayList<Item>();
    }

    public int getSize() {
        return ItemList.size();
    }


    /**
     *search item by code
     */
    private Item search(long code) {
        Iterator<Item> itr = ItemList.iterator();
        Item item;
        while (itr.hasNext()) {
            item = new Item(itr.next());
            if (item.getCode() == code) {
                return item;
            }
        }
        return null;
    }


    /**
     *search item by name
     */
    public Item search(String name) {
        Iterator<Item> itr = ItemList.iterator();
        Item item;
        while (itr.hasNext()) {
            item = new Item(itr.next());
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    /**
     * add item to array list
     */
    public void addItem() {

        //String message="invoked addItem method";

        long aCode;
        String aName;
        double aRate;
        int aQuantity;
        Item foundItem;

        System.out.println("Enter Item code:");
        aCode = sc.nextLong();
        foundItem = search(aCode);

        //return message;

        if (foundItem == null) {

            System.out.println("Item name : ");
            aName = sc.next();
            System.out.println("Rate : ");
            aRate = sc.nextDouble();
            System.out.println("Quantity : ");
            aQuantity = sc.nextInt();
            Item aItem = new Item(aName, aRate, aCode, aQuantity);
            ItemList.add(aItem);

        } else if (foundItem != null) {

            System.out.println("Item exists");

        }
        //return message;
    }

    /**
     * update stock
     */
    public void updateStock() {
        int choice, quantity;
        long code;
        double price;
        Item foundItem;

        System.out.println("1. Update quantity.");
        System.out.println("2. Update rate.");
        System.out.println("Choice:");
        choice = sc.nextInt();

        System.out.println("Enter Item code:");
        code = sc.nextLong();
        foundItem = search(code);
        if (foundItem == null) {
            System.out.println("Item not found");
            return;
        }

        if (choice == 1) {

            System.out.println("Enter quantity to add: ");
            quantity = sc.nextInt();
            foundItem.setQuantity(foundItem.getQuantity() + quantity);
            System.out.println("\n Quantity updated\n");
            System.out.println("Present quantity: " + foundItem.getQuantity());
        }

        else if (choice == 2) {

            System.out.println("Enter new price: ");
            price = sc.nextDouble();
            foundItem.setRate(price);
            System.out.println("\n Price updated\n");
            System.out.println("Present Price: " + foundItem.getRate());
        }

        else {
            System.out.println("Wrong choice!!");
            updateStock();
        }

    }

    /**
     * display items
     */
    public void display() {

        String letter;
        long code;
        Item foundItem;
        String itemName;


        System.out.println("To Display selceted Items press S or To Display all Items press A");
        letter=sc.next();

        if(letter.equals("S")){



            System.out.println("Enter Item names in a comma seperated way:");
            itemName = sc.next();

            String [] items = itemName.split("\\s*,\\s*");

            System.out.println();


            for(int i=0;i<items.length;i++) {
                //String name=items[i];
                //System.out.println(items[i]);
                foundItem = search(items[i]);
                System.out.println(foundItem.toString());
            }

        }else {
            for (Item a : ItemList) {
                System.out.println(a.toString());
            }
        }
    }

    /**
     * issue items method
     */
    public void issueItem() {
        int numberOfItem;
        long code;
        String tmpVal;
        Item foundItem;
        long total=0;

        label1:for(int i=0;;i++) {
        System.out.println("Enter Item code or to exit type exit:");
        tmpVal = sc.next();

            if (tmpVal.equals("exit")) {
                break label1;
            }

            code = Long.parseLong(tmpVal);

            foundItem = search(code);

            if (foundItem == null) {
                System.out.println("Item not found");
                return;
            }

            System.out.println("Number of Item : ");
            numberOfItem = sc.nextInt();
            if (numberOfItem > foundItem.getQuantity()) {
                System.out.println("\nRequired number of Items not in stock\n\n");
                return;
            }


            else {

                total+=numberOfItem * foundItem.getRate();

                System.out.println("\nCost of code num " + code +" of "+ numberOfItem + " items : rs. "
                        + numberOfItem * foundItem.getRate());
                foundItem.setQuantity(foundItem.getQuantity() - numberOfItem);

            }

        }

        System.out.println("----------------------------------------");
        System.out.println("\nTotal value is : rs " + total);
        System.out.println("----------------------------------------");

    }

    /**
     *check price list method
     */
    public double checkPrice(long code) {
        Item foundItem = search(code);
        if (foundItem == null) {
            System.out.println("Item not found");
            return 0.0;
        }

        else
            return foundItem.getRate();
    }

}
