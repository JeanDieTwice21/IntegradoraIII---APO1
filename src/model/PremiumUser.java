package model;
import java.util.ArrayList;

public class PremiumUser extends Users{

    ArrayList<BibliographicProduct> products;

    public PremiumUser(String name, String id, String linkDate){

        super(name, id, linkDate);
        products = new ArrayList<>();
    }

    public void addProduct(BibliographicProduct product){

        products.add(product);
        
    }
}