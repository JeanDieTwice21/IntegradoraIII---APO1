package model;
import java.util.ArrayList;

public abstract class Users{

    private String userName;
    private String userId;
    private String linkDate;


    public Users(String name, String id, String linkDate){

        this.userName = name;
        this.userId = id;
        this.linkDate = linkDate;
    }

/**
 * The function returns the name of the user.
 * 
 * @return The method `getName()` is returning the value of the variable `userName`, which is likely a
 * String representing the name of the user.
 */
    public String getName(){
        return userName;
    }

/**
 * The function returns the user ID as a string.
 * 
 * @return The method `getId()` is returning the value of the variable `userId`, which is likely a
 * string representing the user's identification.
 */
    public String getId(){
        return userId;
    }

/**
 * The function returns the value of the variable "linkDate".
 * 
 * @return The method is returning a String value called "linkDate".
 */
    public String getLinkDate(){
        return linkDate;
    }


}