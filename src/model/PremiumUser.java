package model;
import java.util.ArrayList;

public class PremiumUser extends Users implements BuyProduct{

    private ArrayList<BibliographicProduct> products;
    

    public PremiumUser(String name, String id, String linkDate){

        super(name, id, linkDate);
        products = new ArrayList<>();
        

    }


    @Override
    public String addProduct(BibliographicProduct product){

        products.add(product);
        String msg = "The product has been added. ";

        return msg;
        
    }


    public ArrayList<BibliographicProduct> getProducts(){

        return products;

    }


}