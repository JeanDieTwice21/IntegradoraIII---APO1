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




}