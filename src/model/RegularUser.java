package model;
import java.util.ArrayList;

public class RegularUser extends Users{

    private ArrayList<BibliographicProduct> books;
    private ArrayList<BibliographicProduct> magazines;

    public RegularUser(String name, String id, String linkDate){
        
        super(name, id, linkDate);
        books = new ArrayList<>(5);
        magazines = new ArrayList<>(2);

    } 

/**
 * This function adds a book to a list of books and returns a message indicating whether the addition
 * was successful or not.
 * 
 * @param book The parameter "book" is of type BibliographicProduct, which is an object representing a
 * book with attributes such as title, author, publisher, and ISBN. It is being passed into the method
 * addBook() as an argument.
 * @return The method `addBook` returns a `String` message. If the `books` list already has 5 elements,
 * the message "Array full!" is returned. Otherwise, the method adds the `book` parameter to the
 * `books` list and returns the message "You have bought the book ".
 */
    public String addBook(BibliographicProduct book){
        String msg = "Array full!";

        if(books.size() == 5){
            
            return msg;
        }
        else{

            books.add(book);
            msg = "You have bought the book ";
        }

        return msg;
    }

/**
 * This function adds a magazine to a list of magazines and returns a message indicating whether
 * the addition was successful or not.
 * 
 * @param magazine A BibliographicProduct object representing a magazine that the user wants to add to
 * their subscription list.
 * @return The method returns a String message. If the size of the magazines list is equal to 2, the
 * message "Array full!" is returned. Otherwise, the magazine is added to the list and the message "You
 * have subscribed to the magazine " is returned.
 */
    public String addMagazine(BibliographicProduct magazine){

        String msg = "Array full!";
        if(magazines.size() == 2){
            
            return msg;
        }
        else{

            magazines.add(magazine);
            msg = "You have subscribed to the magazine ";
        }

        return msg;
    }
}