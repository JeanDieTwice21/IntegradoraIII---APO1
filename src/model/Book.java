package model;

public class Book extends BibliographicProduct{

    String review;
    Genre genre;
    double sellPrice;
    int soldBooks;

    public Book(String id, int pagesAmount, String name, String publishDate, String url, String review, Genre genre, double sellPrice){

        super(id, pagesAmount, name, publishDate, url);
        this.review = review;
        this.genre = genre;
        this.sellPrice = sellPrice;
    }

    public void setReview(String newReview){

        this.review = newReview;
    }

    public void setSellPrice(double newPrice){

        this.sellPrice = newPrice;
    }

    public void setGenre(int newGenre){

        if(newGenre == 1){

            this.genre = Genre.SCIENCE_FICTION;
        }
        else if(newGenre == 2){

            this.genre = Genre.FANTASY;
        }
        else if(newGenre == 3){

            this.genre = Genre.HISTORY_NOVEL;
        }
    }
}