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
 * The function adds a bibliographic product to either a list of books or magazines, depending on a
 * flag value, and returns a message indicating success or failure.
 * 
 * @param product A BibliographicProduct object representing the product to be added (either a book or
 * a magazine).
 * @param flag An integer flag that determines whether the product being added is a book or a magazine.
 * If flag is 1, it means the product is a book. If flag is 2, it means the product is a magazine.
 * @return The method `addProduct` returns a message indicating whether the product was successfully
 * added or not. If the product was added, the message will say "You have bought the book" or "You have
 * subscribed to the magazine" depending on the value of the `flag` parameter. If the array is full and
 * the product cannot be added, the message will say "Array full!".
 */
    public String addProduct(BibliographicProduct product, int flag){

        
        String msg = "Array full!";

        if(flag == 1){

            if(books.size() == 5){
            
            return msg;
            }
            else{

                books.add(product);
                msg = "You have bought the book ";
            }

        }
        else if(flag == 2){

            if(magazines.size() == 2){

                return msg;
            }
            else{

                magazines.add(product);
                msg = "You have subscribed to the magazine ";

            }
        }


        return msg;
    }

/**
 * The function returns an ArrayList of BibliographicProduct objects representing books.
 * 
 * @return An ArrayList of BibliographicProduct objects named "books".
 */
    public ArrayList<BibliographicProduct> getBooks(){

        return books;
    }

/**
 * The function returns an ArrayList of BibliographicProduct objects representing magazines.
 * 
 * @return An ArrayList of BibliographicProduct objects named "magazines".
 */
    public ArrayList<BibliographicProduct> getMagazines(){

        return magazines;
    }



}