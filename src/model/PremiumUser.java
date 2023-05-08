package model;

public class PremiumUser extends Users{

    ArrayList<BibliographicProduct> products;

    public PremiumUser(String name, String id, String linkDate){

        super(name, id, linkDate);
        products = new ArrayList<products>();
    }

    public String getName(){
        return name;
    }

    public String getId(){
        return id;
    }

    public String getLinkDate(){
        return linkDate;
    }

    public void addProduct(BibliographicProduct product){

        products.add(product);
        
    }
}