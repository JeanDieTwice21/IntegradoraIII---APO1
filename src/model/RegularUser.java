package model;
import java.util.ArrayList;

public class RegularUser extends Users{

    ArrayList<BibliographicProduct> books;
    ArrayList<BibliographicProduct> magazines;

    public RegularUser(String name, String id, String linkDate){
        
        super(name, id, linkDate);
        books = new ArrayList<>(5);
        magazines = new ArrayList<>(2);

    } 

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