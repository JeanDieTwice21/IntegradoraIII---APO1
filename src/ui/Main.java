package ui;
import java.util.Scanner;
import model.Controller;

public class Main{

    Controller controller;

    public Main(){

        controller = new Controller();
    }

    public static void main(String[] args){

        
    }

    public void menu(){

        System.out.println("-----------------------------------------");
        System.out.println("Welcome ReadX User");
        System.out.println(" ");
        System.out.println("1. Registry bibliographic product");
        System.out.println("2. Delete bibliographic product");
        System.out.println("3. Modify bibliographic product");
        System.out.println("4. Registry user");
        System.out.println("5. Buy a book");
        System.out.println("6. Subscribe to a magazine");
        System.out.println("7. Lecture session");
        System.out.println("8. Exit");
        System.out.prinlnt(" ");
        System.out.println("-----------------------------------------");
    }

    public void executeChoice(int choice){

        switch(choice){

            case 1:
        }
    }

    public void registryBibliographicProduct(){

        String confirmMsg = " ";
        String id = " ";
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
            genreFlag = validateRegisterChoice();
            System.out.println("Enter the price: ");
            sellPrice = reader.nextDouble();


            confirmMsg = controller.registerBook(id, pagesAmount, name, publishDate, url, review, genreFlag, sellPrice);
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

            confirmMsg = controller.registerMagazine(id, pagesAmount, name, publishDate, url, subscriptionPrice, categoryFlag, emissionFrequency);
            System.out.println(confirmMsg);


        }

    }

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

    public int validateRegisterChoice(){
    
        boolean foundValidateInput = false;
        int choice = 0;

        if(reader.hasNextInt()){

            choice = reader.nextInt();

            if(choice == 1 || choice == 2 || choice ==3){

                return choice;

            }
            else{
                
                reader.next();

                do{

                    System.out.println("Invalid choice!");
                    System.out.println(" ");
                    System.out.println("Please, choose a correct option.");
                    choice = reader.nextInt();

                }while(choice != 1 && choice != 2 && choice != 3);

                
            
            }
        }
        else{

            reader.next();

            do{

                System.out.println("That is not a number, please, enter a number: ");
                boolean flag = reader.hasNextInt();
                if(flag == true){

                    choice = reader.nextInt();
                    foundValidateInput = true;
                }
                else{
                    reader.next();

                }

            }while(foundValidateInput != true);
        }
    }


}