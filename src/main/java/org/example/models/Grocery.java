package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {

    public static ArrayList<String> groceryList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void startGrocery() {
        while (true) {
            System.out.println("\n0 - Çıkış | 1 - Ürün Ekle | 2 - Ürün Çıkar");
            System.out.print("Seçiminiz: ");
            String choice = scanner.nextLine();

            if (choice.equals("0")) {
                System.out.println("Program sonlandırıldı.");
                break;
            } else if (choice.equals("1")) {
                System.out.print("Eklemek istediğiniz ürünleri girin (virgülle ayırabilirsiniz): ");
                String input = scanner.nextLine();
                addItems(input);
            } else if (choice.equals("2")) {
                System.out.print("Çıkarmak istediğiniz ürünleri girin (virgülle ayırabilirsiniz): ");
                String input = scanner.nextLine();
                removeItems(input);
            } else {
                System.out.println("Geçersiz seçim!");
            }

            printSorted();
        }
    }

    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String product = item.trim().toLowerCase();
            if (!groceryList.contains(product) && !product.isEmpty()) {
                groceryList.add(product);
            }
        }
        sortList();
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String product = item.trim().toLowerCase();
            groceryList.remove(product);
        }
        sortList();
    }

    public static void sortList() {
        ArrayList<String> uniqueList = new ArrayList<>();
        for (String item : groceryList) {
            if (!uniqueList.contains(item)) {
                uniqueList.add(item);
            }
        }
        groceryList = uniqueList;
        Collections.sort(groceryList);
    }

    public static void printSorted() {
        System.out.println("Güncel Liste:");
        Collections.sort(groceryList);
        for (String item : groceryList) {
            System.out.println(item);
        }
    }
}
