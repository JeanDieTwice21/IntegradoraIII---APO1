package ui;

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
}