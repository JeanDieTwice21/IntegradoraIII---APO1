package model;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Magazine extends BibliographicProduct{

    private double subscriptionPrice;
    private Category category;
    private String emissionFrequency;
    private int activeSubscriptions;
    private double subscriptionSales;


    public Magazine(String id, int pagesAmount, String name, Calendar publishDate, String url, double subscriptionPrice, Category category, String emissionFrequency){

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

/**
 * The function increments the number of active subscriptions by 1.
 */
    public void setActiveSubscription(){

        this.activeSubscriptions += 1;
    }

/**
 * The function returns the number of active subscriptions.
 * 
 * @return The method is returning the value of the variable "activeSubscriptions".
 */
    public int getActiveSubscription(){

        return activeSubscriptions;
    }

/**
 * The function returns the category of an object.
 * 
 * @return The method `getCategory()` is returning an object of the `Category` class.
 */
    public Category getCategory(){

        return category;
    }

/**
 * The function returns the value of subscription sales as a double.
 * 
 * @return The method is returning the value of the variable "subscriptionSales"
 */
    public double getSubSales(){

        return subscriptionSales;
    }

/**
 * The function returns the subscription price as a double data type.
 * 
 * @return The method is returning the value of the variable "subscriptionPrice"
 */
    public double getSubPrice(){

        return subscriptionPrice;
    }

/**
 * This function adds a given value to the total subscription sales.
 * 
 * @param sale a double value representing the amount of subscription sales to be added to the current
 * total subscription sales.
 */
    public void setSubSales(double sale){

        subscriptionSales += sale;
    }
}