
package com.mycompany.finalproject;
// Library class to manage books, users and transactions
class Library {
    public int BooksPerShelf = 4;
    public int initialShelves = 10;

    private Book[][] shelves;
    private User[] users;
    private Transaction[] transactions;
    private int userCount;
    private int transactionCount;
    private int shelfCount;
    private int totalCopies;

    public Library() {
        shelves = new Book[initialShelves][BooksPerShelf];
        users = new User[100];
        transactions = new Transaction[1000];
        userCount = 0;
        transactionCount = 0;
        shelfCount = initialShelves;
    }

    // Add a book to the library
    public boolean addBook(String title, String author, int copies) {
        Book book = findBook(title, author);
        if (book != null) {
            book.addCopies(copies);
        } else {
            book = new Book(title, author, copies);
            if (!placeBookOnShelf(book)) {
                ensureSpaceForBooks();
                placeBookOnShelf(book);
            }
        }
        return true;
    }

    // Place a book on the shelf
    private boolean placeBookOnShelf(Book book) {
        for (int i = 0; i < shelfCount; i++) {
            for (int j = 0; j < BooksPerShelf; j++) {
                if (shelves[i][j] == null) {
                    shelves[i][j] = book;
                    return true;
                }
            }
        }
        return false;
    }

    // Ensure enough shelf space exists
    private void ensureSpaceForBooks() {
        Book[][] newShelves = new Book[shelfCount + 1][BooksPerShelf];
        for (int i = 0; i < shelfCount; i++) {
            System.arraycopy(shelves[i], 0, newShelves[i], 0, BooksPerShelf);
        }
        shelves = newShelves;
        shelfCount++;
        System.out.println("Added a new shelf.");
    }

    // Register a new user
    public boolean registerUser(String name, String email) {
        if (findUser(email) != null) {
            return false;
        }
        users[userCount++] = new User(name, email);
        return true;
    }

    // Borrow a book
    public boolean borrowBook(String email, String title, String author) {
        User user = findUser(email);
        Book book = findBook(title, author);
        if (user != null && book != null && book.borrow()) {
            transactions[transactionCount++] = new Transaction(user, book, "Borrowed");
            return true;
        }
        return false;
    }

    // Return a book
    public boolean returnBook(String email, String title, String author) {
        User user = findUser(email);
        Book book = findBook(title, author);
        if (user != null && book != null && book.returnBook()) {
            transactions[transactionCount++] = new Transaction(user, book, "Returned");
            return true;
        }
        return false;
    }

    // Find a book by title and author
    private Book findBook(String title, String author) {
        for (int i = 0; i < shelfCount; i++) {
            for (int j = 0; j < BooksPerShelf; j++) {
                Book book = shelves[i][j];
                if (book != null && book.getTitle().equals(title) && book.getAuthor().equals(author)) {
                    return book;
                }
            }
        }
        return null;
    }

    // Find a user by email
    private User findUser(String email) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getEmail().equals(email)) {
                return users[i];
            }
        }
        return null;
    }

    // Display all books
    public void displayBooks() {
        for (int i = 0; i < shelfCount; i++) {
            for (int j = 0; j < BooksPerShelf; j++) {
                Book book = shelves[i][j];
                if (book != null) {
                    System.out.printf("%s by %s, %d copies available\n",
                            book.getTitle(), book.getAuthor(), book.getAvailableCopies());
                }
            }
        }
    }

    // Display all transactions
    public void displayTransactions() {
        for (int i = 0; i < transactionCount; i++) {
            System.out.println(transactions[i]);
        }
    }
}

