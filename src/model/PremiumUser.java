package model;
import java.util.ArrayList;

public class PremiumUser extends Users{

    private ArrayList<BibliographicProduct> products;
    private String[][] library;

    public PremiumUser(String name, String id, String linkDate){

        super(name, id, linkDate);
        products = new ArrayList<>();
        library = new String[][]
    }

/**
 * This function adds a BibliographicProduct object to a list of products.
 * 
 * @param product The parameter "product" is an object of the class "BibliographicProduct" that is
 * being passed as an argument to the method "addProduct". This method adds the passed product object
 * to a collection of products.
 */
    public void addProduct(BibliographicProduct product){

        products.add(product);
        
    }
}