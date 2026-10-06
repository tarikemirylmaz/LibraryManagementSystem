
package com.mycompany.finalproject;

import java.util.Scanner;

public class FinalProject {

    public static void main(String[] args){
         try (Scanner scan = new Scanner(System.in)) {
        Library library = new Library();
        
        while (true) {
            System.out.println("\n==== Library Management System ====");
            System.out.println("1. Add New Book");
            System.out.println("2. Register New Member");
            System.out.println("3. Issue Book to Member");
            System.out.println("4. Return Book from Member");
            System.out.println("5. Show All Books");
            System.out.println("6. View All Transactions");
            System.out.println("7. Exit Application");
            System.out.print("Enter your choice: ");
            
            int menuChoice = scan.nextInt();
            scan.nextLine(); 
            
            switch (menuChoice) {
                case 1 -> {
                 System.out.print("Enter Book Title: ");
           String bookTitle = scan.nextLine();
           System.out.print("Enter Book Author: ");
           String bookAuthor = scan.nextLine();

           int totalCopies = 0;
          while (true) {
          System.out.print("Enter Number of Copies: ");
          try {
            totalCopies = Integer.parseInt(scan.nextLine().trim());
            if (totalCopies <= 0) {
                System.out.println("Number of copies must be a positive integer. Please try again.");
            } else {
                break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid number.");
        }
       }

       if(library.addBook(bookTitle, bookAuthor, totalCopies)) {
        System.out.println("Book '" + bookTitle + "' by " + bookAuthor + 
                           " added successfully with " + totalCopies + " copies.");
       } else {
        System.out.println("Failed to add the book.");
           }
       }
                case 2 -> {
                    System.out.print("Enter Member Name: ");
                    String memberName = scan.nextLine();
                    System.out.print("Enter Member Email: ");
                    String memberEmail = scan.nextLine();
                    
                        if (library.registerUser(memberName, memberEmail)) {
                        System.out.println("Member '" + memberName + "' registered successfully.");
                    } else {
                        System.out.println("Failed to register member. Email might already exist.");
                    }
                }
                case 3 -> {
                    System.out.print("Enter Member Email: ");
                    String memberEmail =scan.nextLine();
                    System.out.print("Enter Book Title: ");
                    String bookTitle = scan.nextLine();
                    System.out.print("Enter Book Author: ");
                    String bookAuthor = scan.nextLine();
                    
                    if (library.borrowBook(memberEmail, bookTitle, bookAuthor)) {
                        System.out.println("Book issued successfully.");
                    } else {
                        System.out.println("Failed to issue book.");
                    }
                }
                case 4 -> {
                    System.out.print("Enter Member Email: ");
                    String memberEmail = scan.nextLine();
                    System.out.print("Enter Book Title: ");
                    String bookTitle = scan.nextLine();
                    System.out.print("Enter Book Author: ");
                    String bookAuthor = scan.nextLine();
                    
                    if (library.returnBook(memberEmail, bookTitle, bookAuthor)) {
                        System.out.println("Book returned successfully.");
                    } else {
                        System.out.println("Failed to return book.");
                    }
                }
                case 5 -> library.displayBooks();
                case 6 -> library.displayTransactions();
                case 7 -> {
                    System.out.println("Exiting Library Management System. Goodbye!");
                    scan.close();
                    return;
                }
                default -> System.out.println("Invalid option. Please choose again.");
            }
        }
    }
    }
}
