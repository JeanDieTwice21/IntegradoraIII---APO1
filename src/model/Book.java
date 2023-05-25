package model;
import java.util.Calendar;
import java.util.SimpleDateFormat;


public class Book extends BibliographicProduct{

    private String review;
    private Genre genre;
    private double sellPrice;
    private double sales;
    private int soldBooks;
    

    public Book(String id, int pagesAmount, String name, Calendar publishDate, String url, String review, Genre genre, double sellPrice){

        super(id, pagesAmount, name, publishDate, url);
        this.review = review;
        this.genre = genre;
        this.sellPrice = sellPrice;
    }



    public void increaseSoldBooks(){

        this.soldBooks += 1;
    }

    public void increaseSales(double sale){

        sales += sale;
    }

/**
 * This function sets a new value for the "review" variable.
 * 
 * @param newReview a String variable that represents the new review to be set for an object. The
 * method sets the value of the instance variable "review" to the value of the newReview parameter.
 */
    public void setReview(String newReview){

        this.review = newReview;
    }

/**
 * The function sets the sell price of an object to a new value.
 * 
 * @param newPrice The new price that will be set as the sell price for an object.
 */
    public void setSellPrice(double newPrice){

        this.sellPrice = newPrice;
    }

/**
 * This function sets the genre of an object to a new genre.
 * 
 * @param newGenre The new genre that we want to set for an object.
 */
    public void setGenre(Genre newGenre){

        this.genre = newGenre;
    }

    public Genre getGenre(){

        return genre;
    }

    public double getSales(){

        return sales;
    }

    public int getSoldBooks(){

        return soldBooks;
        
    }

    public double getPrice(){

        return sellPrice;

    }

}