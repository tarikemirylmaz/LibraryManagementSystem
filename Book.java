
package com.mycompany.finalproject;
// Book class to store book information
class Book {
    public String title;
    public String author;
    public int availableCopies;
    public int totalCopies;
    //Constructor to initialize the book object
    Book(String title,String author,int availableCopies, int totalCopies){
        this.title = title;
        this.author = author;
        this.availableCopies = availableCopies;
        this.totalCopies = totalCopies;
    }

    Book(String title, String author, int bookCount) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    //get method to get the title of the book
    public String getTitle(){
        return this.title;
    }
    //get method to get the author of the book
    public String getAuthor(){
        return this.author;
    }
    //Get method to get the number of available copies
     public int getAvailableCopies(){
        return this.availableCopies;
     }
     //Get method to get the total number of copies
     public int gettotalCopies(){
        return this.totalCopies;
     }
       //adding new copy if it is neccessary
     public int addCopy(int copy){
         this.totalCopies += copy;
         this.availableCopies += copy;
         return totalCopies;
     }  
     //// Method to borrow a book
     public boolean borrow(){
         if(this.availableCopies>0){
           this.availableCopies--;
             System.out.println(this.availableCopies + " copy is available ");
           return true;
         }else{
             System.out.println("sorry... no any available copies");
             return false;
         }
     }
      // Method to return a book
     public boolean returnBook(){
         if(this.availableCopies<this.totalCopies && this.availableCopies>0){
             this.availableCopies++;
             System.out.println(this.availableCopies + " copy is available ");
             return true;
         }else{
             System.out.println("all books were returned ");
             return false;
         }
     }    

    void addCopies(int bookCount) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
