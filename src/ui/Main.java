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

        if(option == 1){

            System.out.println("Enter the name of the book: ");
            name = reader.next();
            System.out.println("Enter the publish date: ");
            publishDate = reader.next();
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
            System.out.println("Enter the amount of pages: ");
            pagesAmount = reader.nextInt();

            confirmMsg = controller.registerBook(id, pagesAmount, name, publishDate, url, review, genreFlag, sellPrice);
            System.out.println(confirmMsg);
        }

    }
}