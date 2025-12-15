import java.util.Scanner;

public class User {
    // Guest's username (unique identifier for KTV service)
    private String username;
    // Guest's phone number (used for contact and identity verification)
    private String phonenumber;

    public User(){}
    public User(String username,String phonenumber){
        this.username = username;
        this.phonenumber = phonenumber;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(){
        this.username = username;
    }
    public String getPhonenumber(){
        return phonenumber;
    }
    public void setPhonenumber(){
        this.phonenumber = phonenumber;
    }

    public void check(){
        // Get phone number from User object
        String phone = getPhonenumber();
        // Check if phone number length is not 11 digits
        if(phone.length() != 11){
            // Print error prompt for invalid phone number
            System.out.println("Invalid phone number");
        }
      }
    }