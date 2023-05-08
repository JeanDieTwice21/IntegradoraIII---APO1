package model;

public class RegularUser extends Users{

    ArrayList<BibliographicProduct> books;
    ArrayList<BibliographicProduct> magazines;

    public RegularUser(String name, String id, String linkDate){
        
        super(name, id, linkDate);
        books = new ArrayList<books>(5);
        magazines = new ArrayList<magazines>(2);

    } 

    public String getName(){
        return name;
    }

    public String getId(){
        return id;
    }

    public String getLinkDate(){
        return linkDate;
    }

    public String addBook(BibliographicProduct book){
        String msg = "Array full!";

        if(books.size() == 5){
            
            return msg;
        }
        else{

            books.add(book);
            msg = "You have bought the book ";
        }

        return msg;
    }

    public String addMagazine(BibliographicProduct magazine){

        String msg = "Array full!";
        if(magazines.size() == 2){
            
            return msg;
        }
        else{

        magazine.add(magazine);
            msg = "You have subscribed to the magazine ";
        }

        return msg;
    }
}