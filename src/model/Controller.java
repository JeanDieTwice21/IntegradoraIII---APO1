package model;
import java.util.ArrayList;

public class Controller{

    ArrayList<BibliographicProduct> products;
    ArrayList<Users> users;

    public Controller(){
        
        products = ArrayList<products>();
        users = ArrayList<users>();

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

    public String registerUser(int flag){

        String msg = "User could not be registered";
        int pos = validPositionUsers();
        Users user = null;

        if(pos != -1){

            if(flag == 1){

                user = new RegularUser();
                users.add(user);
                msg = "Regular user has been registered";

            }
            else if(flag == 2){

                user = new PremiumUser();
                users.add(user);
                msg = "Premium user has been registered";

            }

        }
        else{

            msg = "Users array full";
        }
        
        return msg;
    }

}