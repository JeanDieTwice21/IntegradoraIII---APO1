package model;

public abstract class BibliographicProduct{

    private String productId;
    private String productName;
    private int pagesAmount;
    private String publishDate;
    private String url;
    private int pagesRead;

    public BibliographicProduct(String id, int pagesAmount, String name, String publishDate, String url){
        
        this.productId = id;
        this.productName = name;
        this.publishDate = publishDate;
        this.url = url;
        this.pagesAmount = pagesAmount;
    }

    public String getId(){

        return productId;
    }

    public String getName(){

        return productName;
    }

    public String getPublishDate(){

        return publishDate;
    }

    public int getPages(){

        return pagesAmount;
    }

    public void setName(String newName){

        this.productName = newName;
    }

    public void setPages(int newPagesAmount){

        this.pagesAmount = newPagesAmount;

    }

    public void setPublishDate(String newPublishDate){

        this.publishDate = newPublishDate;
    }


    
}