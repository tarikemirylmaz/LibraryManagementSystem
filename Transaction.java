package com.mycompany.finalproject;
// Transaction class to store transaction informations
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
// Transaction class to store transaction details
class Transaction {
    public Book book;
    public User user;
    public String type;
    public String date;
     //Constructor to initialize the transaction object
    Transaction(Book book,User user,String type, String date){
       this.book = book;
       this.user = user;
       this.type = type;
       this.date = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
    }

    Transaction(User user, Book book, String returned) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public String toString(){
    // Formats the string to include the user's name, transaction type, book title, book author, and transaction date
        return String.format("User: %s, Action: %s, Book: '%s' by %s, Date: %s",
            user.getName(), type, book.getTitle(), book.getAuthor(), date);
    }   
}

