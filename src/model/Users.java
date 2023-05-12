package model;

public abstract class Users{

    private String userName;
    private String userId;
    private String linkDate;

    public Users(String name, String id, String linkDate){

        this.userName = name;
        this.userId = id;
        this.linkDate = linkDate;
    }

    public String getName(){
        return userName;
    }

    public String getId(){
        return userId;
    }

    public String getLinkDate(){
        return linkDate;
    }
}