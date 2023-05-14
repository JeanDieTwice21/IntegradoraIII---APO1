package model;

public class Magazine extends BibliographicProduct{

    private double subscriptionPrice;
    private Category category;
    private String emissionFrequency;
    private int activeSubscriptions;


    public Magazine(String id, int pagesAmount, String name, String publishDate, String url, double subscriptionPrice, Category category, String emissionFrequency){

        super(id, pagesAmount, name, publishDate, url);
        this.subscriptionPrice = subscriptionPrice;
        this.category = category;
        this.emissionFrequency = emissionFrequency;
    }

/**
 * This function sets a new subscription price for a certain object.
 * 
 * @param newPrice The new price that is being set for the subscription.
 */
    public void setSubPrice(double newPrice){

        this.subscriptionPrice = newPrice;

    }

/**
 * This function sets the category of an object to a new category.
 * 
 * @param newCategory The new category that we want to set for an object.
 */
    public void setCategory(Category newCategory){

        this.category = newCategory;
    }

/**
 * This function sets the emission frequency to a new value.
 * 
 * @param newFrequency newFrequency is a String parameter that represents the new emission frequency
 * that we want to set for an object. This method sets the emission frequency of the object to the new
 * frequency provided as an argument.
 */
    public void setEmissionFrequency(String newFrequency){

        this.emissionFrequency = newFrequency;
    }
}