package model;

public abstract class BibliographicProduct{

    private String productId;
    private String productName;
    private int pagesAmount;
    private String publishDate;
    private String url;
    private int pagesRead;

    public BibliographicProduct(String id, int pagesAmount, String name, String publishDate, String url, int pagesRead){
        
        this.productId = id;
        this.productName = name;
        this.publishDate = publishDate;
        this.url = url;
        this.pagesAmount = pagesAmount;
        this.pagesRead = pagesRead;
    }

    
}