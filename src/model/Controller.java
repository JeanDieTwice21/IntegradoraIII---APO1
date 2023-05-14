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

/**
 * This function searches for a BibliographicProduct object in a list of products by its ID and returns
 * it.
 * 
 * @param productId a String representing the ID of a bibliographic product that needs to be retrieved
 * from a list of products. The method iterates through the list of products and returns the first
 * product that matches the given ID. If no product is found, it returns null.
 * @return The method is returning a BibliographicProduct object.
 */
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

/**
 * This function registers a new magazine with its properties and adds it to a list of products.
 * 
 * @param pagesAmount The number of pages in the magazine.
 * @param name The name of the magazine being registered.
 * @param publishDate The date when the magazine was published.
 * @param url The URL parameter is a string that represents the web address or location of the
 * magazine, where it can be accessed or downloaded from.
 * @param subscriptionPrice The price that a customer has to pay to subscribe to the magazine.
 * @param categoryFlag An integer value representing the category of the magazine being registered.
 * @param emissionFrequency The frequency at which the magazine is published, such as monthly,
 * bi-monthly, quarterly, etc.
 * @return The method is returning a String message indicating whether the magazine has been
 * successfully registered or not.
 */
    public String registerMagazine(int pagesAmount, String name, String publishDate, String url, double subscriptionPrice, int categoryFlag, String emissionFrequency){
        
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString().replaceAll("-", "").substring(0,3);
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

/**
 * The function registers a user as either a regular or premium user and returns a message indicating
 * whether the registration was successful or not.
 * 
 * @param flag an integer value that determines whether the user being registered is a regular user
 * (flag = 1) or a premium user (flag = 2).
 * @param name The name of the user being registered.
 * @param id The unique identifier for the user being registered.
 * @param linkDate It is a String variable that represents the date when the user's account was linked
 * or created.
 * @return The method is returning a message indicating whether the user was successfully registered as
 * a regular or premium user.
 */
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

/**
 * The function allows a user to buy a bibliographic product (book or magazine) and returns a message
 * indicating whether the purchase was successful or not.
 * 
 * @param productName a String representing the name of the bibliographic product (book or magazine)
 * that the user wants to buy.
 * @param userId The ID of the user who wants to buy the bibliographic product.
 * @return The method is returning a String message indicating the result of the operation of buying a
 * bibliographic product. The message can be "The book [productName] has been bought.", "You have
 * subscribed to the magazine [productName]", or a message returned by the addBook or addMagazine
 * method of the RegularUser class.
 */
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

    public String initSystem(){

        String msg = " ";

        UUID uuid = UUID.randomUUID();
        String bookId = uuid.toString().replace("-", "").substring(0, 3);
        String magazineId = uuid.toString().replaceAll("-", "").substring(0,3);
        Category category = Category.VARIETIES;
        Genre genre = Category.FANTASY;

        BibliographicProduct book1 = new Book(bookId, 8, "Book1", "01/01/2001", "https//Book1.com", "Filling review",  genre, 1000);
        BibliographicProduct magazine1 = new Magazine(magazineId, 10, "Magazine1", "01/01/2001", "https/Magazine1.com", 1000, category, "monthly");
        Users premiumUser = new PremiumUser("Carlos", "9", "02/02/2002");
        Users regularUser = new RegularUser("Ana", "10", "02/02/2002");

        products.add(book1);
        products.add(magazine1);
        users.add(premiumUser);
        users.add(regularUser);

        msg = "System charged. the id of the objects created are: " + "\n" + "Book: " + bookId + "\n" + "Magazine: " + magazineId + "\n" + "Premium User: 9" + "\n" + "Regular user: 10" + "\n" +  "Use these id for tests.";
    
        return msg;
        
    }

    public int sendTotalPagesForSimulation(String productId){

        int totalPages = 0;
        BibliographicProduct product = getProduct(productId);
        totalPages = product.getPages();

        return totalPages;
    }

    public String sendNameForSimulation(String productId){

        String productName = " ";
        BibliographicProduct product = getProduct(productId);
        productName = product.getName();

        return productName;
    }
    

}