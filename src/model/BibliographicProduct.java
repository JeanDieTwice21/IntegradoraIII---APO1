package model;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public abstract class BibliographicProduct implements Comparable<BibliographicProduct>{

    private String productId;
    private String productName;
    private int pagesAmount;
    private Calendar publishDate;
    private String url;
    private int pagesRead;

    public BibliographicProduct(String id, int pagesAmount, String name, Calendar publishDate, String url){
        
        this.productId = id;
        this.productName = name;
        this.publishDate = publishDate;
        this.url = url;
        this.pagesAmount = pagesAmount;
    }

/**
 * The function returns the ID of a product as a string.
 * 
 * @return The method `getId()` is returning a `String` value, which is the `productId`.
 */
    public String getId(){

        return productId;
    }

/**
 * The function returns the name of a product.
 * 
 * @return The method `getName()` is returning the value of the variable `productName`.
 */
    public String getName(){

        return productName;
    }

/**
 * This function returns the publish date of an object as a string.
 * 
 * @return The method is returning a String value, which is the publish date.
 */
    public Calendar getPublishDate(){

        return publishDate;
    }

/**
 * The function "getPages" returns the amount of pages.
 * 
 * @return The method `getPages()` is returning an integer value which represents the amount of pages.
 */
    public int getPages(){

        return pagesAmount;
    }

/**
 * This function sets the name of a product.
 * 
 * @param newName a String variable representing the new name that will be assigned to the productName
 * attribute of an object.
 */
    public void setName(String newName){

        this.productName = newName;
    }

/**
 * This function sets the number of pages for an object.
 * 
 * @param newPagesAmount an integer value representing the new amount of pages to be set for a product.
 */
    public void setPages(int newPagesAmount){

        this.pagesAmount = newPagesAmount;

    }

/**
 * This function sets the publish date of an object to a new value.
 * 
 * @param newPublishDate a String variable that represents the new publish date to be set for an
 * object.
 */
    public void setPublishDate(Calendar newPublishDate){

        this.publishDate = newPublishDate;
    }

/**
 * The function increases the number of pages read by 1.
 */
    public void increaseReadPages(){

        this.pagesRead += 1;
        
    }

/**
 * The function "getReadPages" returns the number of pages read.
 * 
 * @return The method `getReadPages()` is returning the value of the variable `pagesRead`.
 */
    public int getReadPages(){

        return pagesRead;
        
    }

/**
 * This function compares the publish date of two BibliographicProduct objects and returns the result
 * of the comparison.
 * 
 * @param productToCompare This is an object of the class BibliographicProduct that we are comparing to
 * the current object (the one on which the method is being called).
 * @return The method is returning the result of comparing the publish date of the current
 * BibliographicProduct object with the publish date of the BibliographicProduct object passed as a
 * parameter. Specifically, it is returning the result of calling the compareTo method on the publish
 * date of the productToCompare object with the publish date of the current object (publishDate). The
 * result of this comparison is an integer value that indicates the relative
 */
    @Override

    public int compareTo(BibliographicProduct productToCompare){

        return productToCompare.getPublishDate().compareTo(publishDate);
    }

/**
 * The function returns the productId as a string.
 * 
 * @return The `productId` as a string is being returned.
 */
    public String toString(){

        return productId;
    }
}