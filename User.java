
package com.mycompany.finalproject;
// User class to store user information
class User {
    public String name;
    public String email;
    public Book[] borrowedBooks;
    public int borrowedCount;
    //Constructor to initialize the User object
    User(String name, String email){
        this.name = name;
        this.email = email;
        this.borrowedBooks = new Book[3];
        this.borrowedCount = 0;
    }
    // taking name with get method
    public String getName(){
     return this.name;
    }
    //taking email with get method
    public String getEmail(){
        return this.email;
    }
    //taking borrowed books with get method
     public Book[] getBorrowedBooks(){ 
         return this.borrowedBooks;
     }
     //taking borrowed count with get method
     public int getBorrowedCount(){
      return this.borrowedCount;
       }
     //right to borrow
     public boolean canBorrow(){
        return this.borrowedCount < 3;
    }
     //This method checks whether the user can borrow a book and whether the specified book is borrowable
      public boolean borrowBook(Book book){
        if(canBorrow() && book.borrow()){
            borrowedBooks[borrowedCount++] = book;
            return true;
        }else{
              return false;
        }    
     }
      //The purpose of this method is to return a borrowed book 
        public boolean returnBook(Book book){
        for (int i = 0; i < borrowedCount; i++){
            if (borrowedBooks[i]== book){
                book.returnBook();
                borrowedBooks[i] = borrowedBooks[--borrowedCount];
                Book fullness = null;
                borrowedBooks[borrowedCount]= fullness;
                return true;
            }
        }
        return false;
    }
}
