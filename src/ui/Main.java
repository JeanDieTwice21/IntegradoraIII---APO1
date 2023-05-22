package ui;
import java.util.Scanner;
import model.Controller;

public class Main{

    private Controller controller;
    private Scanner reader;

    public Main(){

        reader = new Scanner(System.in);
        controller = new Controller();
    }

    public static void main(String[] args){

        Main view = new Main();

        int choice = 0;

        do{
            
            view.menu();
            choice = view.validateIntegerInput();
            view.executeChoice(choice);


        }while(choice != 8);
        
    }

/**
 * The function displays a menu for a ReadX user with options to perform various actions.
 */
    public void menu(){

        System.out.println("-----------------------------------------");
        System.out.println("Welcome ReadX User");
        System.out.println(" ");
        System.out.println("1. Registry bibliographic product");
        System.out.println("2. Delete bibliographic product");
        System.out.println("3. Modify bibliographic product");
        System.out.println("4. Registry user");
        System.out.println("5. Buy a bibliographic product");
        System.out.println("6. Lecture session");
        System.out.println("7. Get informed about the amount of read pages");
        System.out.println("7. Init system.");
        System.out.println("8. Exit");
        System.out.println(" ");
        System.out.println("-----------------------------------------");
    }

/**
 * This function executes a specific action based on the user's choice from a menu.
 * 
 * @param choice an integer representing the user's choice from a menu of options. The method executes
 * a specific action based on the user's choice using a switch statement.
 */
    public void executeChoice(int choice){

        switch(choice){

            case 1:

                System.out.println("------------------------------");
                registryBibliographicProduct();
                break;
            
            case 2:
                
                System.out.println("------------------------------");
                deleteBibliographicProduct();
                break;
            
            case 3:
            
                System.out.println("------------------------------");
                modifyBibliographicProduct();
                break;
            
            case 4:

                System.out.println("-------------------------------");
                registryUser();
                break;
            
            case 5:

                System.out.println("--------------------------------");
                buyBibliographicProduct();
                break;
            
            case 6:
                
                System.out.println("---------------------------------");
                simulateLecture();
                break;
            
            case 7:
                
                System.out.println("-----------------------------------");
                initSystem();
                break;
            
            case 8:

                System.out.println("---------------------------------------");
                System.out.println("Goodbye.");
                break;


        }
    }

/**
 * This function allows the user to register a book or magazine by inputting various details such as
 * name, publish date, pages amount, and genre.
 */
    public void registryBibliographicProduct(){

        String confirmMsg = " ";
        int pagesAmount = 0;
        String name = " ";
        String publishDate = " ";
        String url = " ";
        String review = " ";
        int genreFlag = 0;
        double sellPrice = 0;
        int option = 0;

        System.out.println("Choose what bibliographic product do you want to registry: ");
        System.out.println(" ");
        System.out.println("1. Book");
        System.out.println("2. Magazine");
        option = reader.nextInt();
        System.out.println("Enter the name of the product: ");
        name = reader.next();
        System.out.println("Enter the publish date: ");
        publishDate = reader.next();
        System.out.println("Enter the amount of pages: ");
        pagesAmount = reader.nextInt();   
        System.out.println("Enter the url of the product: ");     

        if(option == 1){

       
            System.out.println("Enter a show review: ");
            reader.next();
            review = reader.nextLine();
            System.out.println("Choose the genre: ");
            System.out.println("1. Science fiction");
            System.out.println("2. Fantasy");
            System.out.println("3. History novel");
            genreFlag = reader.nextInt();
            System.out.println("Enter the price: ");
            sellPrice = reader.nextDouble();


            confirmMsg = controller.registerBook(pagesAmount, name, publishDate, url, review, genreFlag, sellPrice);
            System.out.println(confirmMsg);
        }
        else if(option == 2){

            System.out.println("Enter the subscription price: ");
            double subscriptionPrice = reader.nextDouble();
            System.out.println("Choose the category: ");
            System.out.println("1. Varieties");
            System.out.println("2. Design");
            System.out.println("3. Science");
            int categoryFlag = reader.nextInt();
            System.out.println("Enter the emission frequency: ");
            String emissionFrequency = reader.next();

            confirmMsg = controller.registerMagazine(pagesAmount, name, publishDate, url, subscriptionPrice, categoryFlag, emissionFrequency);
            System.out.println(confirmMsg);


        }

    }

/**
 * This function prompts the user to input information about a new user and then registers them using a
 * controller method.
 */
    public void registryUser(){

        String name = " ";
        String id = " ";
        String linkDate = " ";
        int userFlag = 0;
        String confirmMsg = " ";

        System.out.println("Choose the kind of user: ");
        System.out.println("1. Premium user");
        System.out.println("2. Regular user");
        userFlag = reader.nextInt();

        System.out.println("Enter the name: ");
        name = reader.next();
        System.out.println("Enter the id: ");
        id = reader.next();
        System.out.println("Enter the link date: ");
        linkDate = reader.next();

        confirmMsg = controller.registerUser(userFlag, name, id, linkDate);

        System.out.println(confirmMsg);

    }

/**
 * This function prompts the user to input an ID for a bibliographic product to delete and then
 * calls a controller function to delete the product.
 */
    public void deleteBibliographicProduct(){

        String productId = " ";
        String confirmMsg = " ";

        System.out.println("Type the id of the product to delete: ");
        productId = reader.next();

        confirmMsg = controller.deleteBibliographicProduct(productId);

        System.out.println(confirmMsg);
    }

/**
 * This function prompts the user to input a product name and user ID, then calls a controller
 * method to buy the bibliographic product and prints a confirmation message.
 */
    public void buyBibliographicProduct(){

        String productName = " ";
        String userId = " ";
        String confirmMsg = " ";

        System.out.println("Type the name of the product to buy: ");
        productName = reader.next();
        System.out.println("Type your id: ");
        userId = reader.next();

        confirmMsg = controller.buyBibliographicProduct(productName, userId);

        System.out.println(confirmMsg);

    }


/**
 * This function allows the user to modify the attributes of a book or magazine product in a library
 * system.
 */
    public void modifyBibliographicProduct(){

        int firstOption = 0;
        int secondOption = 0;
        String productId = " ";
        int thirdOption = 0;

        System.out.println("Choose the type of product: ");
        System.out.println("1. Book");
        System.out.println("2. Magazaine");
        firstOption = reader.nextInt();
        System.out.println("Enter the id of the product to modify: ");
        productId = reader.next();

        if(firstOption == 1){

            
            
            do{
                
            
                

                System.out.println("What do you want to modify? ");
                System.out.println("1. Book name");
                System.out.println("2. Book pages amount");
                System.out.println("3. Book publish date");
                System.out.println("4. Book review");
                System.out.println("5. Book genre");
                System.out.println("6. Book price");
                System.out.println("7. Nothing");
                secondOption = reader.nextInt();

                if(secondOption == 1){
                    
                    String newName = " ";
                    System.out.println("Enter the new name: ");
                    newName = reader.next();
                    System.out.println(controller.modifyProductName(productId, newName)); 
                }
                else if(secondOption == 2){

                    int newPagesAmount = 0;
                    System.out.println("Enter the new pages amount: ");
                    newPagesAmount = reader.nextInt();
                    System.out.println(controller.modifyProductPages(productId, newPagesAmount));
                }
                else if(secondOption == 3){
                    
                    String newDate = " ";
                    System.out.println("Enter the new publish date: ");
                    newDate = reader.next();
                    System.out.println(controller.modifyProductDate(productId, newDate));

                }
                else if(secondOption == 4){
                    
                    String newReview = " ";
                    System.out.println("Enter the new review: ");
                    reader.next();
                    newReview = reader.nextLine();
                    System.out.println(controller.modifyBookReview(productId, newReview));

                }
                else if(secondOption == 5){

                    int newGenre = 0;
                    System.out.println("Choose the genre: ");
                    System.out.println("1. Science fiction");
                    System.out.println("2. Fantasy");
                    System.out.println("3. History novel");
                    newGenre = reader.nextInt();
                    System.out.println(controller.modifyBookGenre(productId, newGenre));


                }
                else if(secondOption == 6){
                    
                    double newPrice = 0;
                    System.out.println("Enter the new price: ");
                    newPrice = reader.nextDouble();
                    System.out.println(controller.modifyBookPrice(productId, newPrice));

                }

            }while(secondOption != 7);

        }
        else if(firstOption == 2){


            do{
            
                System.out.println("What do you want to modify? ");
                System.out.println("1. Magazine name");
                System.out.println("2. Magazine pages amount");
                System.out.println("3. Magazine publish date");
                System.out.println("4. Magazine emission frequency");
                System.out.println("5. Magazine category");
                System.out.println("6. Magazine subscription price");
                System.out.println("7. Nothing");
                secondOption = reader.nextInt();

                if(thirdOption == 1){
                    
                    String newName = " ";
                    System.out.println("Enter the new name: ");
                    newName = reader.next();
                    System.out.println(controller.modifyProductName(productId, newName)); 
                }
                else if(thirdOption == 2){

                    int newPagesAmount = 0;
                    System.out.println("Enter the new pages amount: ");
                    newPagesAmount = reader.nextInt();
                    System.out.println(controller.modifyProductPages(productId, newPagesAmount));
                }
                else if(thirdOption == 3){
                    
                    String newDate = " ";
                    System.out.println("Enter the new publish date: ");
                    newDate = reader.next();
                    System.out.println(controller.modifyProductDate(productId, newDate));

                }
                else if(thirdOption == 4){
                    
                    String newFrequency = " ";
                    System.out.println("Enter the new frequency: ");
                    newFrequency = reader.next();
                    System.out.println(controller.modifyMagazineEmission(productId, newFrequency));

                }
                else if(thirdOption == 5){

                    int newCategory = 0;
                    System.out.println("Choose the new category: ");
                    System.out.println("1. Varieties");
                    System.out.println("2. Design");
                    System.out.println("3. Science");
                    newCategory = reader.nextInt();
                    System.out.println(controller.modifyMagazineCategory(productId, newCategory));


                }
                else if(thirdOption == 6){
                    
                    double newPrice = 0;
                    System.out.println("Enter the new price: ");
                    newPrice = reader.nextDouble();
                    System.out.println(controller.modifyMagazineSubPrice(productId, newPrice));

                }

            }while(thirdOption != 7);
        }
    }


/**
 * This function simulates a lecture by allowing the user to read a product's pages and move forward or
 * backward until they finish the lecture.
 */
    public void simulateLecture(){

        String productId = " ";
        int totalPages = 0;
        String productName = " ";
        int startPages = 1;
        int option = 0;


        System.out.println("Enter the id of the product to read: ");
        productId = reader.next();

        productName =  controller.sendNameForSimulation(productId);
        totalPages = controller.sendTotalPagesForSimulation(productId);

        do{

            System.out.println("Lecture session in progress: " + "\n");
            System.out.println("Reading: " + productName);
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("Reading page " + startPages + " of" + totalPages);
            System.out.println(" ");
            System.out.println("Enter 1 to move forward.");
            System.out.println("Enter 2 to move backward.");
            System.out.println("Enter 3 to finish the lecture.");
            option = reader.nextInt();

            if(option == 1){

                startPages++;
                controller.modifyReadPages();
            }
            else if(option == 2){

                startPages--;
            }
            

        }while(option != 3 && startPages != totalPages);


    }

    public void informPagesRead(){

        System.out.println(controller.informPagesRead());
        
    }

/**
 * This function initializes the system and prints the result of the initialization process.
 */
    public void initSystem(){

        System.out.println(controller.initSystem());
    }
 

/**
 * This function validates user input to ensure it is an integer and returns the integer value or -1 if
 * the input is invalid.
 * 
 * @return The method is returning an integer value.
 */
    public int validateIntegerInput(){
        int option = 0; 
        if(reader.hasNextInt()){
            option = reader.nextInt(); 
        }
        else{
            reader.nextLine();
            option = -1; 
            System.out.println("Enter a valid value."); 
        }
        return option; 
    }


}