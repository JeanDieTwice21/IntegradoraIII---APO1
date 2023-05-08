package model;
import java.util.ArrayList;

public class Controller{

    ArrayList<BibliographicProduct> products;
    ArrayList<Users> users;

    public Controller(){
        
        products = new ArrayList<products>();
        users = new ArrayList<users>();

    }

    public String registerBook(String id, int pagesAmount, String name, String publishDate, String url, String review, int genreFlag, double sellPrice){
        
        String msg = " ";
        Genre genre = null;

        if(genreFlag == 1){

            genre = Genre.SCIENCE_FICTION;
        }
        else if(genreFlag == 2){

            genre = Genre.FANTASY;

        }
        else if(genreFlag == 3){

            genre = Genre.HISTORY_NOVEL;
            
        }

        BibliographicProduct book = new Book(String id, int pagesAmount, String name, String publishDate, String url, String review, Genre genre, double sellPrice);
        products.add(book);
        msg = "The book has been registered";

        return msg;
    }

    public String deleteBibliographicProduct(String productId){

        String msg = "Couldnt delete product";
        boolean productFound = false;

        for(int i = 0; i < products.size() && !productFound; i++){
            BibliographicProduct product = products.get(i);
            if(product.getId().equals(productId)){
                
                productFound = true;
                products.remove(i);
                msg = "The product " + product.getName() + " was deleted.";

            }

        }

        return msg;

    }

    public String modifyBibliographicProduct(String productId){


        String msg =
    }

    public String registerMagazine(String id, int pagesAmount, String name, String publishDate, String url, int pagesRead, double subscriptionPrice, int categoryFlag, String emissionFrequency){

        String msg = " ";
        Category category = null;

        if(categoryFlag == 1){
        
            category = Category.VARIETIES;

        }
        else if(categoryFlag == 2){

            category = Category.DESING;

        }
        else if(categoryFlag == 3){

            category = Category.SCIENCE;

        }

        BibliographicProduct magazine = new Magazine(String id, int pagesAmount, String name, String publishDate, String url, double subscriptionPrice, Category category, String emissionFrequency);
        products.add(magazine);
        msg = "The magazine has been registered";

        return msg;
    }

    public String registerUser(int flag, String name, String id, String linkDate){

        String msg = "User could not be registered";
        Users user = null;


            if(flag == 1){

                user = new RegularUser(name, id, linkDate);
                users.add(user);
                msg = "Regular user has been registered";

            }
            else if(flag == 2){

                user = new PremiumUser(name, id, linkDate);
                users.add(user);
                msg = "Premium user has been registered";
            }
            
        
        return msg;
    }

    public String buyBibliographicProduct(String productName, String userId){
        
        String msg = " ";

        boolean prouductFound = false;

        for(int i = 0; i < products.size() && !bookFound; i++){
            
            BibliographicProduct product = producs.get(i);
            if(product instanceof Book && product.getName().equals(productName)){

                productFound = true;

                for(int j = 0; j < users.size() && !userFound; j++){

                    Users user = users.get(j);
                    if(user instanceof PremiumUser && user.getId().equals(userId)){
                        
                        userFound = true;
                        user.addProduct(product);
                        msg = "The book " + productName + "has been bought.":
                    }
                    else if(user instanceof RegularUser && user.getId().equals(userId)){

                        userFound = true;
                        msg = user.addBook(product) + productName;
                        

                    }
                }
                
            }
            else if(product instanceof Magazine && product.getName().equals(productName)){

                productFound = true;

                for(int j = 0; j < users.size() && !userFound; j++){

                    Users user = users.get(j);
                    if(user instanceof PremiumUser && user.getId().equals(userId)){
                        
                        userFound = true;
                        user.addProduct(product);
                        msg = "You have subscribed to the magazine " + productName; 
                    }
                    else if(user instanceof RegularUser && user.getId().equals(userId)){

                        userFound = true;
                        msg = user.addMagazine(product) + productName;
                    }                
            }

        }

        }

        return msg;

    }
    

}