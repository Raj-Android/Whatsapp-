package com.example.whatsappclone.Model;

public class User {
    String email,password,userName,userId,profilePic,lastMessage;
    //create constructor
    public User(String email, String password, String userName, String userId, String profilePic, String lastMessage) {
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.userId = userId;
        this.profilePic = profilePic;
        this.lastMessage = lastMessage;
    }
    //create empty constructor for firebase
    public  User(){

    }
    //create Signup constructor
    public User(String userName,String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    //create getter and setter
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }




    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public void getUserId(String key) {

    }
}
