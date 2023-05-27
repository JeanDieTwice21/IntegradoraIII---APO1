package model;
import java.util.ArrayList;
import java.util.UUID;
import java.util.Random;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Controller{

    private ArrayList<BibliographicProduct> products;
    private ArrayList<Users> users;


    public Controller(){
        
        products = new ArrayList<>();
        users = new ArrayList<>();

    }

/**
 * The function registers a book with given parameters and adds it to a list of products.
 * 
 * @param pagesAmount an integer representing the number of pages in the book
 * @param name The name of the book being registered.
 * @param publishDate The date when the book was published.
 * @param url The URL parameter is a string that represents the URL of the book's webpage or online
 * store page.
 * @param review A string containing a review or description of the book.
 * @param genreFlag An integer value representing the genre of the book. 1 represents Science Fiction,
 * 2 represents Fantasy, and 3 represents History Novel.
 * @param sellPrice The price at which the book will be sold.
 * @return The method is returning a message indicating that the book has been registered and providing
 * its ID.
 */
    public String registerBook(int pagesAmount, String name, String publishDateStr, String url, String review, int genreFlag, double sellPrice) throws Exception{
        
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString().replace("-", "").substring(0, 3);
        Calendar publishDate = stringsToCalendar(publishDateStr);

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

/**
 * This function deletes a bibliographic product from a list of products based on its ID and
 * returns a message indicating whether the deletion was successful or not.
 * 
 * @param productId a String representing the ID of the bibliographic product that needs to be deleted
 * from a list of products.
 * @return The method is returning a message indicating whether the product was successfully deleted or
 * not. If the product is found and deleted, the message will say "The product [product name] was
 * deleted." If the product is not found, the message will say "Couldn't delete product."
 */
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

 /**
  * This function modifies the name of a product and returns a message indicating the original and new
  * names.
  * 
  * @param productId A String representing the unique identifier of a bibliographic product.
  * @param newName The new name that will replace the current name of the product.
  * @return The method is returning a message that indicates the original name of a product was changed
  * to a new name. The message is in the format "The name: [original name] was changed to: [new name]".
  */
    public String modifyProductName(String productId, String newName){

        BibliographicProduct product = getProduct(productId);
        String originalName = product.getName();
        product.setName(newName);
        String msg = "The name: " + originalName + " was changed to: " + newName;

        return msg;

    }

/**
 * This function modifies the publish date of a bibliographic product and returns a message indicating
 * the change.
 * 
 * @param productId a String representing the unique identifier of a bibliographic product.
 * @param newDate A string representing the new publish date that will replace the current publish date
 * of a bibliographic product.
 * @return The method is returning a message that indicates the original publish date of a product has
 * been changed to a new date. The message includes both the original date and the new date.
 */
    public String modifyProductDate(String productId, String newDateStr) throws Exception{
        
        Calendar newDate = stringsToCalendar(newDateStr);
        BibliographicProduct product = getProduct(productId);
        Calendar originalDate = product.getPublishDate();
        product.setPublishDate(newDate);
        String msg = "The publish date " + originalDate + " was changed to: " + newDate;

        return msg;
    }

/**
 * This function modifies the number of pages of a bibliographic product and returns a message
 * indicating the change.
 * 
 * @param productId a String representing the unique identifier of a bibliographic product.
 * @param newPagesAmount an integer representing the new amount of pages for a bibliographic product.
 * @return The method is returning a String message that informs the user that the amount of pages of a
 * product has been changed from the original amount to a new amount.
 */
    public String modifyProductPages(String productId, int newPagesAmount){

        BibliographicProduct product = getProduct(productId);
        int originalPagesAmount = product.getPages();
        product.setPages(newPagesAmount);
        String msg = "The amount of pages " + originalPagesAmount + " has been changed to " + newPagesAmount;

        return msg;
    }

/**
 * This function modifies the review of a book in a list of products based on the book's ID.
 * 
 * @param productId A String representing the ID of the book product whose review needs to be modified.
 * @param newReview The new review that will replace the existing review of the book.
 * @return The method is returning a message indicating whether the book review was successfully
 * updated or not. If the book is found and updated, the message will be "The review has been updated".
 * If the book is not found, the message will be an empty string.
 */
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

/**
 * This function modifies the sell price of a book in a list of products based on the book's ID.
 * 
 * @param productId a String representing the unique identifier of a bibliographic product (in this
 * case, a book)
 * @param newPrice a double value representing the new price of a book
 * @return The method is returning a String message indicating whether the price of the book with the
 * given productId has been updated or not.
 */
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

/**
 * This function modifies the subscription price of a magazine product in a list of bibliographic
 * products.
 * 
 * @param productId a String representing the ID of a bibliographic product (in this case, a magazine)
 * @param newPrice a double value representing the new subscription price for a magazine product.
 * @return The method returns a String message indicating whether the price of the magazine
 * subscription has been updated or not.
 */
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

/**
 * The function modifies the emission frequency of a magazine product in a list of bibliographic
 * products.
 * 
 * @param productId a String representing the ID of the magazine product to be modified.
 * @param newFrequency A String representing the new emission frequency that will be set for a Magazine
 * object.
 * @return The method returns a String message indicating whether the magazine with the given productId
 * was found and its emission frequency was updated or not.
 */
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

/**
 * The function modifies the genre of a book in a list of bibliographic products based on a given
 * product ID and genre flag.
 * 
 * @param productId A String representing the ID of the book product to be modified.
 * @param genreFlag An integer value representing the new genre to be assigned to a book.
 * @return The method is returning a String message indicating whether the genre of a book has been
 * updated or not.
 */
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

/**
 * This function modifies the category of a magazine product based on a given category flag.
 * 
 * @param productId A String representing the ID of the magazine product that needs to be modified.
 * @param categoryFlag An integer value representing the new category to be assigned to a magazine
 * product. The possible values are 1, 2, or 3, which correspond to the categories VARIETIES, DESIGN,
 * and SCIENCE, respectively.
 * @return The method is returning a message indicating whether the magazine category has been updated
 * or not. The message is stored in the variable "msg".
 */
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
    public String registerMagazine(int pagesAmount, String name, String publishDateStr, String url, double subscriptionPrice, int categoryFlag, String emissionFrequency) throws Exception{
        
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString().replaceAll("[^a-zA-Z0-9]", "").substring(0, 3);
        String msg = " ";
        Category category = null;
        Calendar publishDate = stringsToCalendar(publishDateStr);

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
        msg = "The magazine has been registered, the id is: " + id;

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


            if(flag == 2){

                user = new RegularUser(name, id, linkDate);
                users.add(user);
                msg = "Regular user has been registered";

            }
            else if(flag == 1){

                user = new PremiumUser(name, id, linkDate);
                users.add(user);
                msg = "Premium user has been registered";
            }
            
        
        return msg;
    }


/**
 * The function allows a user to buy a book by searching for the book in a list of products and adding
 * it to the user's account.
 * 
 * @param productName The name of the book that the user wants to buy.
 * @param userId The ID of the user who wants to buy the book.
 * @return The method is returning a message indicating whether the book was successfully bought or
 * not. 
 */
    public String buyBook(String productName, String userId){
        

        boolean productFound = false;
        boolean userFound = false;
        String msg = " ";
        double bookPrice = 0;
        int flag = 1;

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
                        Book book = (Book) product;
                        book.increaseSoldBooks();
                        bookPrice = book.getPrice();
                        book.increaseSales(bookPrice);

                        msg = "The book " + productName + "has been bought.";
                    }
                    else if(user instanceof RegularUser && user.getId().equals(userId)){

                        RegularUser regularUser = (RegularUser) user;
                        userFound = true;
                        msg = regularUser.addProduct(product, flag) + productName;
                        Book book = (Book) product;
                        book.increaseSoldBooks();
                        bookPrice = book.getPrice();
                        book.increaseSales(bookPrice);
                        
                    }
                }
                
            }

        }

        return msg;

    }

/**
 * The function allows a user to buy a magazine by checking if the product and user exist, and adding
 * the magazine to the user's account.
 * 
 * @param productName The name of the magazine that the user wants to buy.
 * @param userId The ID of the user who wants to buy the magazine.
 * @return The method is returning a message (String) indicating whether the user has successfully
 * subscribed to the magazine or not.
 */
    public String buyMagazine(String productName, String userId){
        

        boolean productFound = false;
        boolean userFound = false;
        double subscriptionPrice = 0;
        String msg = " ";
        int flag = 2;

        for(int i = 0; i < products.size() && !productFound; i++){
            
            BibliographicProduct product = products.get(i);

            if(product instanceof Magazine && product.getName().equals(productName)){

                productFound = true;

                for(int j = 0; j < users.size() && !userFound; j++){

                    Users user = users.get(j);
                    
                    if(user instanceof PremiumUser && user.getId().equals(userId)){
                        PremiumUser premiumUser = (PremiumUser) user;
                        userFound = true;
                        premiumUser.addProduct(product);
                        msg = "You have subscribed to magazine " + productName;
                        Magazine magazine = (Magazine) product;
                        magazine.setActiveSubscription();
                        subscriptionPrice = magazine.getSubPrice();
                    }
                    else if(user instanceof RegularUser && user.getId().equals(userId)){
                        RegularUser regularUser = (RegularUser) user;
                        userFound = true;
                        msg = regularUser.addProduct(product, flag) + productName;
                        Magazine magazine = (Magazine) product;
                        magazine.setActiveSubscription();
                        

                    }
                }
                
            }

        }

        return msg;

    }

/**
 * The function initializes a system by creating and adding objects such as books, magazines, and
 * users, and returns a message with their respective IDs.
 * 
 * @return The method is returning a String message that confirms the system has been charged and
 * provides the IDs of the objects created for testing purposes.
 */
    public String initSystem() throws Exception{

        String msg = " ";

        UUID uuid1 = UUID.randomUUID();
        String bookId = uuid1.toString().replace("-", "").substring(0, 3);
        UUID uuid2 = UUID.randomUUID();
        String magazineId = uuid2.toString().replaceAll("[^a-zA-Z0-9]", "").substring(0, 3);
        Category category = Category.VARIETIES;
        Genre genre = Genre.FANTASY;

        Calendar date = stringsToCalendar("01/01/2001");

        BibliographicProduct book1 = new Book(bookId, 8, "Book1", date, "https//Book1.com", "Filling review",  genre, 1000);
        BibliographicProduct magazine1 = new Magazine(magazineId, 10, "Magazine1", date, "https/Magazine1.com", 1000, category, "monthly");
        Users premiumUser = new PremiumUser("Carlos", "9", "02/02/2002");
        Users regularUser = new RegularUser("Ana", "10", "02/02/2002");

        products.add(book1);
        products.add(magazine1);
        users.add(premiumUser);
        users.add(regularUser);

        msg = "System charged. the id of the objects created are: " + "\n" + "Book: " + " Book1 " + bookId + "\n" + "Magazine: " + " Magazine1 " + magazineId + "\n" + "Premium User: 9" + "\n" + "Regular user: 10" + "\n" +  "Use these id for tests.";
    
        return msg;

    }

/**
 * The function returns the total number of pages for a given product ID.
 * 
 * @param productId A string representing the unique identifier of a bibliographic product.
 * @return The method is returning an integer value which represents the total number of pages of a
 * bibliographic product identified by the given productId.
 */
    public int sendTotalPagesForSimulation(String productId){

        int totalPages = 0;
        BibliographicProduct product = getProduct(productId);
        totalPages = product.getPages();

        return totalPages;
    }

/**
 * This function retrieves the name of a product based on its ID and returns it as a string.
 * 
 * @param productId A string representing the unique identifier of a product.
 * @return The method is returning a String variable named "productName", which contains the name of a
 * product obtained from a BibliographicProduct object.
 */
    public String sendNameForSimulation(String productId){

        String productName = " ";
        BibliographicProduct product = getProduct(productId);
        productName = product.getName();

        return productName;
    }

/**
 * This function modifies the number of read pages for a given product.
 * 
 * @param productId a String representing the unique identifier of a bibliographic product.
 */
    public void modifyReadPages(String productId){

        BibliographicProduct product = getProduct(productId);

        product.increaseReadPages();

        
    }

    
/**
 * The function calculates the total number of pages read for books and magazines in a list of
 * bibliographic products and returns the result as a formatted string.
 * 
 * @return A string containing the total number of pages read for books and magazines in the products
 * list.
 */
    public String informPagesRead(){
        
        int amountForBook = 0;
        int amountForMagazine = 0;

        for(int i = 0; i < products.size(); i++){
            
            BibliographicProduct product = products.get(i);

            if(product instanceof Book){

                amountForBook += product.getReadPages();

            }
            else if(product instanceof Magazine){

                amountForMagazine += product.getReadPages();
            }
            
        }

        return "Type: Book." + "\n" + "Total read pages: " + amountForBook + "\n" + "Type: Magazine." + "\n" + "Total read pages: " + amountForMagazine;
    }
    
/**
 * The function determines whether a product is a book or not based on its type.
 * 
 * @param productId a String representing the unique identifier of a product.
 * @return A boolean value indicating whether the product with the given ID is a book or not.
 */
    public boolean knowTypeOfProduct(String productId){

        boolean isBook = false;

        BibliographicProduct product = getProduct(productId);

        if(product instanceof Book){

            isBook = true;

        }
        else if(product instanceof Magazine){

            isBook = false;

        }

        return isBook;
    }

/**
 * The function returns a randomly selected advertisement from a list of three options.
 * 
 * @return A randomly selected advertisement from the array of ads.
 */
    public String showAds(){

        Random random = new Random();
        String[] ads = {"Subscribe to Combo Plus and get Disney+ and Star+ at an incredible price!", "Now your pets have a favorite app: Laika. The best products for your furry friend.", "It's our anniversary! Visit your nearest Éxito and be surprised with the best offers."};
        int randomIndex = random.nextInt(ads.length);

        return ads[randomIndex];

    }

/**
 * The function calculates and returns the active subscrpitons and the total sales for the different categories of magazines in the
 * product list.
 * 
 * @return The method is returning a String with the statistics of the active subscriptions and total
 * sales for each category of magazines: Varieties, Design, and Science.
 */
    public String informCategoriesStats(){

        int varietiesSubscriptions = 0;
        int desingSubscriptions = 0;
        int sciencieSubscriptions = 0;
        double varietiesSales = 0;
        double desingSales = 0;
        double scienceSales = 0;

        for(int i = 0; i < products.size(); i++){

            BibliographicProduct product = products.get(i);

            if(product instanceof Magazine){
                
                Magazine magazine = (Magazine) product;
                Category magazineCategory = magazine.getCategory();

                if(magazineCategory == Category.VARIETIES){

                    varietiesSubscriptions += magazine.getActiveSubscription();
                    varietiesSales += magazine.getSubSales();
                }
                else if(magazineCategory == Category.DESING){
                    
                    desingSubscriptions += magazine.getActiveSubscription();
                    desingSales += magazine.getSubSales();

                }
                else if(magazineCategory == Category.SCIENCE){

                    sciencieSubscriptions += magazine.getActiveSubscription();
                    scienceSales += magazine.getSubSales();

                }

            }
        }

        String msg1 = "Category: Varieties. " + "\nActive subscriptions: " + varietiesSubscriptions + "\nTotal sales: " + varietiesSales;
        String msg2 = "Category: Desing. " + "\nActive subscriptions: " + desingSubscriptions + "\nTotal sales: " + desingSales;
        String msg3 = "Category: Science. " + "\nActive subscriptions: " + sciencieSubscriptions + "\nTotal sales: " + scienceSales;

        return msg1 + "\n" + msg2 + "\n" + msg3;

    }

/**
 * The function calculates and returns the sales and number of sold books for each genre of books in
 * the products list.
 * 
 * @return The method is returning a String that contains the statistics for the sales and sold books
 * of three different genres: science fiction, fantasy, and history novel.
 */
    public String informGenresStats(){

        int scienceFictionSoldBooks = 0;
        int fantasySoldBooks = 0;
        int historyNovelSoldBooks = 0;
        double scienceFictionSales = 0;
        double fantasySales = 0;
        double historyNovelSales = 0;

        for(int i = 0; i < products.size(); i++){

            BibliographicProduct product = products.get(i);

            if(product instanceof Book){
                
                Book book = (Book) product;
                Genre bookGenre = book.getGenre();

                if(bookGenre == Genre.SCIENCE_FICTION){

                    scienceFictionSoldBooks += book.getSoldBooks();
                    scienceFictionSales += book.getSales();
                }
                else if(bookGenre == Genre.FANTASY){
                    
                    fantasySoldBooks += book.getSoldBooks();
                    fantasySales += book.getSales();

                }
                else if(bookGenre == Genre.HISTORY_NOVEL){

                    historyNovelSoldBooks += book.getSoldBooks();
                    historyNovelSales += book.getSales();

                }

            }
        }

        String msg1 = "Genre: Science fiction. " + "\nSold books: " + scienceFictionSoldBooks + "\nTotal sales: " + scienceFictionSales;
        String msg2 = "Genre: Fantasy. " + "\nSold books: " + fantasySoldBooks + "\nTotal sales: " + fantasySales;
        String msg3 = "Genre: History novel. " + "\nSold books: " + historyNovelSoldBooks + "\nTotal sales: " + historyNovelSales;

        return msg1 + "\n" + msg2 + "\n" + msg3;

    }


/**
 * The function returns the most read genre and category along with the total pages read for each.
 * 
 * @return The method is returning a string that contains information about the most read genre and
 * category, along with the total number of pages read for each.
 */
    public String informMostReadGenreAndCategory(){

        int maxPagesReadGenre = 0;
        int maxPagesReadCategory = 0;
        int pagesReadGenre = 0;
        int pagesReadCategory = 0;
        Genre mostReadGenre = null;
        Category mostReadCategory = null;

        for(int i = 0; i < products.size(); i++){

            BibliographicProduct product = products.get(i);

            if(product instanceof Book){

                Book book = (Book) product;
                pagesReadGenre = book.getReadPages();

                if(pagesReadGenre > maxPagesReadGenre){

                    maxPagesReadGenre = pagesReadGenre;
                    mostReadGenre = book.getGenre();
                }

            }
        }

        for(int j = 0; j < products.size(); j++){

            BibliographicProduct product = products.get(j);

            if(product instanceof Magazine){

                Magazine magazine = (Magazine) product;
                pagesReadCategory = magazine.getReadPages();

                if(pagesReadCategory > maxPagesReadCategory){
                    
                    maxPagesReadCategory = pagesReadCategory;
                    mostReadCategory = magazine.getCategory();

                }
            }
        }

        return "Most read genre: " + mostReadGenre + "\nTotal pages: " + maxPagesReadGenre + "\nMost read category: " + mostReadCategory + "\nTotal pages: " + maxPagesReadCategory;

    }

/**
 * The function checks if a user is a premium user or a regular user based on their user ID.
 * 
 * @param userId A String representing the ID of the user whose type needs to be checked.
 * @return A boolean value indicating whether the user with the given ID is a premium user or not.
 */

    public boolean checkTypeOfUser(String userId){

        boolean completed = false;
        boolean isPremium = false;

        for(int i = 0; i < users.size(); i++){
            
            Users user = users.get(i);

            if(user instanceof PremiumUser && user.getId().equals(userId)){

                isPremium = true;
                completed = true;

            }
            else if(user instanceof RegularUser && user.getId().equals(userId)){

                isPremium = false;
                completed = true;

            }
        }

        return isPremium;
    }



/**
 * The function converts a string date in the format "dd/MM/yyyy" to a Calendar object.
 * 
 * @param date The date parameter is a string representing a date in the format "dd/MM/yyyy".
 * @return A Calendar object is being returned.
 */
    public Calendar stringsToCalendar(String date) throws Exception{
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        Calendar newDate = Calendar.getInstance();
        newDate.setTime(formatter.parse(date));

        return newDate; 
    }


    public String[][] userProductsMatrix(String userId) {

        String msg = " ";
        boolean userFound = false;
        int row = 5;
        int column = 5;
        String[][] productIdMatrix = new String[row][column];

        for (int x = 0; x < users.size() && !userFound; x++) {
            Users user = users.get(x);

            if (user.getId().equals(userId) && user instanceof PremiumUser) {
                PremiumUser premiumUser = (PremiumUser) user;
                userFound = true;

                ArrayList<BibliographicProduct> userProd = bubbleSort(premiumUser.getProducts());

                int k = 0;

                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < column; j++) {
                        if (k < userProd.size()) {
                            productIdMatrix[i][j] = userProd.get(k).getId();
                            k++;
                        } 
                        else{
                        // Si ya no hay más productos en userProd, se puede asignar un valor indicativo o dejarlo en blanco
                        // dependiendo de tus requisitos.
                            productIdMatrix[i][j] = ""; // O algún otro valor indicativo
                        }
                    }
                }
            }
        }

        return productIdMatrix;
    }

    public String showUserLibrary(String userId){

        String[][] productMatrix = userProductsMatrix(userId);
        String msg = " ";

        for(int i = 0; i < 5; i++){
            for(int x = 0; x < 5; x++){
                if(productMatrix[i][x] != null){

                    msg += productMatrix[i][x] + " ";
                }
                else{

                    msg += "__";
                }
                    
            }

            msg += "\n";
        }

        return msg;
    }


    public ArrayList<BibliographicProduct> bubbleSort(ArrayList<BibliographicProduct> products) {

        int n = products.size();

        for (int i = 0; i < n - 1; i++) {

            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (products.get(j).compareTo(products.get(j + 1)) > 0) {
                    BibliographicProduct product = products.get(j);
                    products.set(j, products.get(j + 1));
                    products.set(j + 1, product);
                    swapped = true;
                }
            }

            if(!swapped){

                break;
            }
        }

        return products;
    }

    public String getUserName(String userId){
        
        String userName = " ";
        boolean userFound = false;

        for(int i = 0; i < users.size() && !userFound; i++){
            if(users.get(i).getId().equals(userId)){

                userFound = true;
                userName = users.get(i).getName();
            }
        }

        return userName;
    }


}