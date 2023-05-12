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

    public void setSubPrice(double newPrice){

        this.subscriptionPrice = subscriptionPrice;

    }

    public void setCategory(int newCategory){

        if(newCategory == 1){

            this.category = Category.VARIETIES;
        }
        else if(newCategory == 2){

            this.category = Category.DESING;

        }
        else if(newCategory == 3){

            this.category = Category.SCIENCE;
        }
    }

    public void setEmissionFrequency(String newFrequency){

        this.emissionFrequency = newFrequency;
    }
}