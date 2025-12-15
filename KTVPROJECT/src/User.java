/**
 * User class represents a customer in the KTV system.
 * It stores user information such as username and phone number.
 */
public class User {
    // Guest's username (unique identifier for KTV service)
    private String username;
    // Guest's phone number (used for contact and identity verification)
    private String phonenumber;

    /**
     * Default constructor for User
     */
    public User() {}

    /**
     * Constructor with parameters to initialize user information
     *
     * @param username The user's name
     * @param phonenumber The user's phone number
     */
    public User(String username, String phonenumber) {
        this.username = username;
        this.phonenumber = phonenumber;
    }

    /**
     * Get the username
     *
     * @return The username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the username
     *
     * @param username The username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get the phone number
     *
     * @return The phone number
     */
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     * Set the phone number
     *
     * @param phonenumber The phone number to set
     */
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    /**
     * Validate user information
     * Currently only checks if phone number has 11 digits
     */
    public void check() {
        // Get phone number from User object
        String phone = getPhonenumber();
        // Check if phone number length is not 11 digits
        if (phone.length() != 11) {
            // Print error prompt for invalid phone number
            System.out.println("Invalid phone number");
        }
    }
}