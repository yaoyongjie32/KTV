import java.util.Scanner;
import java.util.Random;

/**
 * Driver class is the main entry point for the KTV management system.
 * It handles the overall flow of the application including user input,
 * room booking, service ordering, and information retrieval.
 */
class Driver {
    public static void main(String[] args) {
        // Arrays to store customer information (up to 10 customers)
        String[] phonenumberlibrary = new String[10];
        String[] namelibrary = new String[10];
        String[] daylibrary = new String[10];
        String[] datelibrary = new String[10];
        String[] timelibrary = new String[10];
        String[] modellibrary = new String[10];
        double[] durationlibrary = new double[10];
        double[] pricelibrary = new double[10];

        // Initialize and display KTV main menu
        Menu m = new Menu();
        m.menu();

        // Create Scanner object for user input
        Scanner sc = new Scanner(System.in);

        int count = 0;
        // Infinite loop to serve multiple guests (break when answer == 0)
        while (count < 10) {
            System.out.println("Serve next guest or not (0/1) ：");
            int answer = sc.nextInt();
            sc.nextLine(); // Consume newline character to avoid input mismatch

            // If select to serve next guest (answer == 1)
            if (answer == 1) {
                // Step 1: Collect guest's phone number
                System.out.println("Phone Number：");
                String phonenumber = sc.nextLine();
                phonenumberlibrary[count] = phonenumber;

                // Step 2: Collect guest's username
                System.out.println("Username：");
                String username = sc.nextLine();
                namelibrary[count] = username;

                // Step 3: Create User object and execute user info check logic
                User u = new User(username, phonenumber);
                u.check();

                // Step 4: Create Room object and calculate room price (collect booking info: date, time, duration, room type, VIP)
                Room p = new Room();
                p.price();
                daylibrary[count] = p.getDaystring();
                datelibrary[count] = p.getDatestring();
                timelibrary[count] = p.getTimestring();
                modellibrary[count] = p.getModelstring();
                durationlibrary[count] = p.getDuration();

                // Get VIP selection status from Room object (1=Purchase, 0=Not purchase, -1=Invalid)
                int vipChoice = p.getVIPchoice();

                // Step 5: Generate random 3-digit room number (000-999)
                Random r = new Random();
                int roomnumber;
                int num1 = r.nextInt(10); // Random digit (0-9) for hundreds place
                int num2 = r.nextInt(10); // Random digit (0-9) for tens place
                int num3 = r.nextInt(10); // Random digit (0-9) for units place
                roomnumber = num1 * 100 + num2 * 10 + num3;
                // Display welcome message and assigned room number
                System.out.println("Welcome to GATHERING KTV, Room Number：" + roomnumber);

                // Step 6: Handle beverage and snack service (pass VIP status for privilege check)
                System.out.println("Beverage and Snack Service：");
                Service s = new Service();
                s.beverage(vipChoice); // Pass VIP choice to service method (VIP may have discounts/free items)

                // Calculate total price (room price + beverage/snack service price)
//                double price = p.getroomprice() + s.getserviceprice();
                double price = p.getroomprice() + s.getserviceprice();
                pricelibrary[count] = price;
                count++;

                // Step 7: Handle private room light effect control (VIP-only feature)
                System.out.println("Select Private Room Light Effect (VIP only)：");
                Controlsystem c = new Controlsystem();
                c.controlsystem(vipChoice); // Pass VIP choice to control light effect (only VIP can select)

                System.out.println("Total Price：" + price);
                System.out.println("Have a great time!");
            }
            // If select not to serve next guest (answer == 0)
            else {
                // Prompt exit from input mode
                System.out.println("Entry Exited");
                // Break the loop and terminate the program
                break;
            }
        }

        // Information search section
        System.out.println("Welcome to Information Search");
        while (true) {
            System.out.println("Enter 1 to start, 0 to end");
            int searchingdecision = sc.nextInt();
            sc.nextLine();
            if (searchingdecision == 1) {
                System.out.println("Please enter the mobile phone number to search for");
                String searchingphonenumber = sc.nextLine();
                System.out.println("Please enter the user's name to search for");
                String searchingusername = sc.nextLine();
                boolean found = false;
                int foundIndex = -1;
                for (int i = 0; i < phonenumberlibrary.length; i++) {
                    if (phonenumberlibrary[i] != null && namelibrary[i] != null &&
                            searchingphonenumber.equals(phonenumberlibrary[i]) &&
                            searchingusername.equals(namelibrary[i])) {
                        found = true;
                        foundIndex = i;
                        break;
                    }
                }
                if (found) {
                    System.out.println("name: " + namelibrary[foundIndex]);
                    System.out.println("phonenumber: " + phonenumberlibrary[foundIndex]);
                    System.out.println("date: " + datelibrary[foundIndex]);
                    System.out.println("day: " + daylibrary[foundIndex]);
                    System.out.println("time: " + timelibrary[foundIndex]);
                    System.out.println("duaration: " + durationlibrary[foundIndex]);
                    System.out.println("price: " + pricelibrary[foundIndex]);
                } else {
                    System.out.println("The user information has been entered incorrectly");
                }
            } else {
                System.out.println("Entry Exited");
                break;
            }
        }
    }
}