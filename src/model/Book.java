package model;
import java.util.Calendar;
import java.text.SimpleDateFormat;


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



/**
 * This function increases the number of sold books by 1.
 */
    public void increaseSoldBooks(){

        this.soldBooks += 1;
    }

/**
 * The function increases the value of a sales variable by a given amount.
 * 
 * @param sale a double value representing the amount by which the sales are to be increased.
 */
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

/**
 * The function returns the genre of a media object.
 * 
 * @return The method is returning an object of the `Genre` class.
 */
    public Genre getGenre(){

        return genre;
    }

/**
 * The function returns the value of the sales variable as a double.
 * 
 * @return The method is returning a double value, which is the value of the variable "sales".
 */
    public double getSales(){

        return sales;
    }

/**
 * The function returns the number of sold books.
 * 
 * @return The method is returning an integer value representing the number of sold books.
 */
    public int getSoldBooks(){

        return soldBooks;
        
    }

/**
 * The getPrice() function returns the sell price as a double.
 * 
 * @return The method `getPrice()` is returning the value of the `sellPrice` variable, which is of type
 * `double`.
 */
    public double getPrice(){

        return sellPrice;

    }

}