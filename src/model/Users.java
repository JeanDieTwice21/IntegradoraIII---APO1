package model;

public abstract class Users{

    private String userName;
    private String userId;
    private String linkDate;

    public Users(String name, String id, String linkDate){

        this.name = name;
        this.id = id;
        this.linkDate = linkDate;
    }
}