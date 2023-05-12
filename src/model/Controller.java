package model;
import java.util.ArrayList;
import java.util.UUID;

public class Controller{

    ArrayList<BibliographicProduct> products;
    ArrayList<Users> users;

    public Controller(){
        
        products = new ArrayList<>();
        users = new ArrayList<>();

    }

    public String registerBook(int pagesAmount, String name, String publishDate, String url, String review, int genreFlag, double sellPrice){
        
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString().replace("-", "").substring(0, 3);

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

        BibliographicProduct book = new Book(id, pagesAmount, name, publishDate, url, review,  genre,  sellPrice);
        products.add(book);
        msg = "The book has been registered, the id is: " + id;

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

    public String modifyProductName(String productId, String newName){

        BibliographicProduct product = getProduct(productId);
        String originalName = product.getName();
        product.setName(newName);
        String msg = "The name: " + originalName + " was changed to: " + newName;

        return msg;

    }

    public String modifyProductDate(String productId, String newDate){

        BibliographicProduct product = getProduct(productId);
        String originalDate = product.getPublishDate();
        product.setPublishDate(newDate);
        String msg = "The publish date " + originalDate + " was changed to: " + newDate;

        return msg;
    }

    public String modifyProductPages(String productId, int newPagesAmount){

        BibliographicProduct product = getProduct(productId);
        int originalPagesAmount = product.getPages();
        product.setPages(newPagesAmount);
        String msg = "The amount of pages " + originalPagesAmount + " has been changed to " + newPagesAmount;

        return msg;
    }

    public String modifyBookReview(String productId, String newReview){

        boolean bookFound = false;
        String msg = " ";

        for(int i = 0; i < products.size() && !bookFound; i++){
            BibliographicProduct product = products.get(i);
            if(product.getId().equals(productId) && product instanceof Book){
                Book book = (Book) product;
                bookFound = true;
                book.setReview(newReview);
                msg = "The review has been updated";        
            }
        }

        return msg;
    }

    public String modifyBookPrice(String productId, double newPrice){

        boolean bookFound = false;
        String msg = " ";

        for(int i = 0; i < products.size() && !bookFound; i++){
            BibliographicProduct product = products.get(i);
            if(product.getId().equals(productId) && product instanceof Book){
                Book book = (Book) product;
                bookFound = true;
                book.setSellPrice(newPrice);
                msg = "The price has been updated";        
            }
        }

        return msg;
        
    }

    public String modifyMagazineSubPrice(String productId, double newPrice){

        boolean magazineFound = false;
        String msg = " ";

        for(int i = 0; i < products.size() && !magazineFound; i++){
            BibliographicProduct product = products.get(i);
            if(product.getId().equals(productId) && product instanceof Magazine){
                Magazine magazine = (Magazine) product;
                magazineFound = true;
                magazine.setSubPrice(newPrice);
                msg = "The price has been updated";
            }

        }

        return msg;
    }

    public String modifyMagazineEmission(String productId, String newFrequency){

        boolean magazineFound = false;
        String msg = " ";

        for(int i = 0; i < products.size() && !magazineFound; i++){
            BibliographicProduct product = products.get(i);
            if(product.getId().equals(productId) && product instanceof Magazine){
                Magazine magazine = (Magazine) product;
                magazineFound = true;
                magazine.setEmissionFrequency(newFrequency);
                msg = "The frequency has been uptaded";
            }

        }

        return msg;
    }

    public String modifyBookGenre(String productId, int genreFlag){

        boolean bookFound = false;
        String msg = " ";
        Genre newGenre = null;

        for(int i = 0; i < products.size() && !bookFound; i++){
            BibliographicProduct product = products.get(i);
            if(product.getId().equals(productId) && product instanceof Book){
                Book book = (Book) product;
                bookFound = true;

                if(genreFlag == 1){

                    newGenre = Genre.SCIENCE_FICTION;
                }
                else if(genreFlag == 2){

                    newGenre = Genre.FANTASY;
                }
                else if(genreFlag == 3){

                    newGenre = Genre.HISTORY_NOVEL;
                }

                book.setGenre(newGenre);
                msg = "The genre has been updated";
            }
        }

        return msg;
        
    }

    public String modifyMagazineCategory(String productId, int categoryFlag){

        boolean magazineFound = false;
        String msg = " ";
        Category newCategory = null;

        for(int i = 0; i < products.size() && !magazineFound; i++){
            BibliographicProduct product = products.get(i);
            if(product.getId().equals(productId) && product instanceof Magazine){
                Magazine magazine = (Magazine) product;
                magazineFound = true;

                if(categoryFlag == 1){
                    newCategory = Category.VARIETIES;
                }
                else if(categoryFlag == 2){
                    newCategory = Category.DESING;
                }
                else if(categoryFlag == 3){
                    newCategory = Category.SCIENCE;
                }

                magazine.setCategory(newCategory);

                msg = "The frequency has been uptaded";
            }

        }

        return msg;

    }

    public BibliographicProduct getProduct(String productId){

        boolean productFound = false;
        BibliographicProduct product = null;

        for(int i = 0; i < products.size() && !productFound; i++){
            product = products.get(i);
            if(product.getId().equals(productId)){

                productFound = true;

            }
        }

        return product;
    }

    public String registerMagazine(String id, int pagesAmount, String name, String publishDate, String url, double subscriptionPrice, int categoryFlag, String emissionFrequency){

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

        BibliographicProduct magazine = new Magazine( id, pagesAmount, name,  publishDate,  url,  subscriptionPrice, category, emissionFrequency);
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

        boolean productFound = false;
        boolean userFound = false;

        for(int i = 0; i < products.size() && !productFound; i++){
            
            BibliographicProduct product = products.get(i);
            if(product instanceof Book && product.getName().equals(productName)){

                productFound = true;

                for(int j = 0; j < users.size() && !userFound; j++){

                    Users user = users.get(j);
                    if(user instanceof PremiumUser && user.getId().equals(userId)){
                        PremiumUser premiumUser = (PremiumUser) user;
                        userFound = true;
                        premiumUser.addProduct(product);
                        msg = "The book " + productName + "has been bought.";
                    }
                    else if(user instanceof RegularUser && user.getId().equals(userId)){
                        RegularUser regularUser = (RegularUser) user;
                        userFound = true;
                        msg = regularUser.addBook(product) + productName;
                        

                    }
                }
                
            }
            else if(product instanceof Magazine && product.getName().equals(productName)){

                productFound = true;

                for(int j = 0; j < users.size() && !userFound; j++){

                    Users user = users.get(j);
                    if(user instanceof PremiumUser && user.getId().equals(userId)){
                        PremiumUser premiumUser = (PremiumUser) user;
                        userFound = true;
                        premiumUser.addProduct(product);
                        msg = "You have subscribed to the magazine " + productName; 
                    }
                    else if(user instanceof RegularUser && user.getId().equals(userId)){
                        RegularUser regularUser = (RegularUser) user;
                        userFound = true;
                        msg = regularUser.addMagazine(product) + productName;
                    }                
            }

        }

        }

        return msg;

    }
    

}