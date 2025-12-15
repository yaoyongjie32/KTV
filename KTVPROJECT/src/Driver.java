import java.util.Scanner;
import java.util.Random;

class Driver {
    public static void main(String[] args){
        // Initialize and display KTV main menu
        Menu m = new Menu();
        m.menu();

        // Create Scanner object for user input
        Scanner sc = new Scanner(System.in);

        // Infinite loop to serve multiple guests (break when answer == 0)
        while(true){
            System.out.println("Serve next guest or not (0/1) ：");
            int answer = sc.nextInt();
            sc.nextLine(); // Consume newline character to avoid input mismatch

            // If select to serve next guest (answer == 1)
            if(answer == 1){
                // Step 1: Collect guest's phone number
                System.out.println("Phone Number：");
                String phonenumber = sc.nextLine();

                // Step 2: Collect guest's username
                System.out.println("Username：");
                String username = sc.nextLine();

                // Step 3: Create User object and execute user info check logic
                User u = new User(username,phonenumber);
                u.check();

                // Step 4: Create Room object and calculate room price (collect booking info: date, time, duration, room type, VIP)
                Room p = new Room();
                p.price();

                // Get VIP selection status from Room object (1=Purchase, 0=Not purchase, -1=Invalid)
                int vipChoice = p.getVIPchoice();

                // Step 5: Generate random 3-digit room number (000-999)
                Random r = new Random();
                int roomnumber;
                int num1 = r.nextInt(10); // Random digit (0-9) for hundreds place
                int num2 = r.nextInt(10); // Random digit (0-9) for tens place
                int num3 = r.nextInt(10); // Random digit (0-9) for units place
                roomnumber = num1*100 + num2*10 + num3;
                // Display welcome message and assigned room number
                System.out.println("Welcome to GATHERING KTV, Room Number：" + roomnumber);

                // Step 6: Handle beverage and snack service (pass VIP status for privilege check)
                System.out.println("Beverage and Snack Service：");
                Service s = new Service();
                s.beverage(vipChoice); // Pass VIP choice to service method (VIP may have discounts/free items)

                // Calculate total price (room price + beverage/snack service price)
                double price = p.getroomprice() + s.getserviceprice();

                // Step 7: Handle private room light effect control (VIP-only feature)
                System.out.println("Select Private Room Light Effect (VIP only)：");
                Controlsystem c = new Controlsystem();
                c.controlsystem(vipChoice); // Pass VIP choice to control light effect (only VIP can select)


                System.out.println("Total Price：" + price);
                System.out.println("Have a great time!");
            }
            // If select not to serve next guest (answer == 0)
            else{
                // Prompt exit from input mode
                System.out.println("Entry Exited");
                // Break the loop and terminate the program
                break;
            }
        }
    }
}