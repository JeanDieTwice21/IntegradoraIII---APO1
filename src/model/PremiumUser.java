package model;

public class PremiumUser extends Users{

    public PremiumUser(String name, String id, String linkDate){

        super(name, id, linkDate);
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
}