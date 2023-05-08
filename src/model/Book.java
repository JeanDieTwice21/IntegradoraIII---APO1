package ui;

public class Book extends BibliographicProduct{

    String review;
    Genre genre;
    double sellPrice;
    int soldBooks;

    public Book(String id, int pagesAmount, String name, String publishDate, String url, String review, Genre genre, double sellPrice, int soldBooks){

        super(id, pagesAmount, name, publishDate, url);
        this.review = review;
        this.genre = genre;
        this.sellPrice = sellPrice;
        this.soldBooks = soldBooks;
    }
}