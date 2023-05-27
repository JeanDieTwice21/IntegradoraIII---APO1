package model;
import java.util.ArrayList;

public class PremiumUser extends Users implements BuyProduct{

    private ArrayList<BibliographicProduct> products;
    

    public PremiumUser(String name, String id, String linkDate){

        super(name, id, linkDate);
        products = new ArrayList<>();
        

    }


/**
 * This Java function adds a bibliographic product to a list and returns a message confirming the
 * addition.
 * 
 * @param product The parameter "product" is an object of the class "BibliographicProduct" that is
 * being added to a list of products.
 * @return A string message indicating that the product has been added.
 */
    @Override
    public String addProduct(BibliographicProduct product){

        products.add(product);
        String msg = "The product has been added. ";

        return msg;
        
    }


/**
 * The function returns an ArrayList of BibliographicProduct objects.
 * 
 * @return An ArrayList of BibliographicProduct objects named "products".
 */
    public ArrayList<BibliographicProduct> getProducts(){

        return products;

    }


}