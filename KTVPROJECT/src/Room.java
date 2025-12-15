import java.util.Scanner;

/**
 * Room class handles room booking functionality in the KTV system.
 * It manages room types, pricing, booking dates/times, and VIP packages.
 */
public class Room {
    // Duration of room booking (in hours)
    private double duration;
    // User's selection for day (1=Monday, 2=Tuesday...7=Sunday)
    private int daychoice;
    // String representation of selected day (e.g., "Monday")
    private String daystring;
    // User input date string (free text)
    private String datestring;
    // User's selection for time period (1-4 correspond to different time segments)
    private int timechoice;
    // String representation of selected time period (e.g., "9:00~12:00")
    private String timestring;
    // User's selection for room model (1=small, 2=medium, 3=large)
    private int modelchoice;
    // String representation of selected room model (e.g., "Private Room: ¥60 per Hour")
    private String modelstring;
    // User's selection for VIP package (1=VIP, 2=SVIP)
    private int packagechoice;
    // Total price of the private room (initial value: 0)
    private double roomprice = 0;
    // Store VIP purchase choice: 1=Purchase, 0=Not purchase, -1=Not selected (initial state)
    private int vipChoice = -1;

    /**
     * Calculate time multiplier based on day and time period
     *
     * @return The calculated time multiplier
     */
    public double times() {
        // Day multiplier (1 for weekdays, 1.6 for weekends)
        double day;
        // Final time multiplier (day * time segment multiplier)
        double times = 0;

        // Set day multiplier based on selected day
        if (daychoice == 1 || daychoice == 2 || daychoice == 3 || daychoice == 4 || daychoice == 5) {
            day = 1; // Weekdays (Monday to Friday)
        } else if (daychoice == 6 || daychoice == 7) {
            day = 1.6; // Weekends (Saturday to Sunday)
        } else {
            System.out.println("Error"); // Invalid day selection
            return 0;
        }

        // Set time segment multiplier and calculate total time multiplier
        switch (timechoice) {
            case 1: // Time period 1 (9:00~12:00)
                times = times + day * 1;
                break;
            case 2: // Time period 2 (12:00~17:00)
                times = times + day * 1.2;
                break;
            case 3: // Time period 3 (17:00~21:00)
                times = times + day * 1.5;
                break;
            case 4: // Time period 4 (21:00~9:00)
                times = times + day * 1.1;
                break;
            default: // Invalid time period selection
                System.out.println("Error");
                return 0;
        }
        return times;
    }

    /**
     * Calculate base room price based on room model and duration
     *
     * @return The calculated model price
     */
    public double modelprice() {
        // Base price of selected room type (initial value: 0)
        double modelprice = 0;
        // Calculate base price based on selected room model
        switch (modelchoice) {
            case 1: // Small private room (¥60/hour)
                modelprice = modelprice + 60 * duration;
                break;
            case 2: // Medium private room (¥80/hour)
                modelprice = modelprice + 80 * duration;
                break;
            case 3: // Large private room (¥95/hour)
                modelprice = modelprice + 95 * duration;
                break;
        }
        return modelprice;
    }

    /**
     * Prompt user for VIP choice if not already made
     *
     * @return The VIP choice (1 for purchase, 0 for not purchase)
     */
    public int VIPchoice() {
        if (vipChoice == -1) { // Only prompt if VIP choice is not made
            Scanner sc = new Scanner(System.in);
            System.out.println("Purchase VIP or not (0/1) : ");
            vipChoice = sc.nextInt();
        }
        return vipChoice;
    }

    /**
     * Get the VIP choice
     *
     * @return The VIP choice
     */
    public int getVIPchoice() {
        return vipChoice;
    }

    /**
     * Set VIP choice (for use by other classes)
     *
     * @param choice The VIP choice to set
     */
    public void setVIPchoice(int choice) {
        this.vipChoice = choice;
    }

    /**
     * Handle the room booking process and calculate pricing
     */
    public void price() {
        Scanner sc = new Scanner(System.in);
        // Step 1: Input date (free text)
        System.out.println("Please enter the date：");
        datestring = sc.nextLine();

        // Step 2: Display day list and get user's day selection
        String[] daylist = new String[7];
        daylist[0] = "Monday";
        daylist[1] = "Tuesday";
        daylist[2] = "Wednesday";
        daylist[3] = "Thursday";
        daylist[4] = "Friday";
        daylist[5] = "Saturday";
        daylist[6] = "Sunday";
        System.out.println("Select Date: 1 represent " + daylist[0]);
        System.out.println("Select Date: 2 represent " + daylist[1]);
        System.out.println("Select Date: 3 represent " + daylist[2]);
        System.out.println("Select Date: 4 represent " + daylist[3]);
        System.out.println("Select Date: 5 represent " + daylist[4]);
        System.out.println("Select Date: 6 represent " + daylist[5]);
        System.out.println("Select Date: 7 represent " + daylist[6]);
        daychoice = sc.nextInt();
        daystring = daylist[daychoice - 1]; // Map selection to day string

        // Step 3: Display time period list and get user's time selection
        String[] timelist = new String[4];
        timelist[0] = "9:00~12:00";
        timelist[1] = "12:00~17:00";
        timelist[2] = "17:00~21:00";
        timelist[3] = "21:00~9:00";
        System.out.println("Select Time Period: 1 for " + timelist[0]);
        System.out.println("Select Time Period: 2 for " + timelist[1]);
        System.out.println("Select Time Period: 3 for " + timelist[2]);
        System.out.println("Select Time Period: 4 for " + timelist[3]);
        timechoice = sc.nextInt();
        timestring = timelist[timechoice - 1]; // Map selection to time string

        // Step 4: Input booking duration (hours)
        System.out.println("Please enter the duration (hours)：");
        duration = sc.nextDouble();

        // Step 5: Display room type list and get user's room selection
        String[] modellist = new String[3];
        modellist[0] = "Private Room: ¥60 per Hour";
        modellist[1] = "Medium Private Room: ¥80 per Hour";
        modellist[2] = "Large Private Room: ¥95 per Hour";
        System.out.println("Select Room: 1 for " + modellist[0]);
        System.out.println("Select Room: 2 for " + modellist[1]);
        System.out.println("Select Room: 3 for " + modellist[2]);
        modelchoice = sc.nextInt();
        modelstring = modellist[modelchoice - 1]; // Map selection to room type string

        // Step 6: Display VIP packages and calculate price based on VIP choice
        String[] packagelist = new String[2];
        packagelist[0] = "VIP ¥79: 20% Off + Free Drinks + Partial Lighting Optional";
        packagelist[1] = "SVIP ¥149: 35% Off + 1 Extra Hour + Free Drinks + All Lighting Optional";
        int vipchoice = VIPchoice();

        // Calculate total price if user purchases VIP
        if (vipchoice == 1) {
            System.out.println("Select Package (Enter 1 for package1, 2 for package2):");
            System.out.println("package1:" + packagelist[0] + "  package2:" + packagelist[1]);
            packagechoice = sc.nextInt();
            switch (packagechoice) {
                case 1: // VIP package (¥79 + 20% discount)
                    roomprice = (modelprice() * times() + 79) * 0.8;
                    break;
                case 2: // SVIP package (¥149 + 35% discount + 1 extra hour)
                    roomprice = (modelprice() * times() + 149) * 0.65;
                    duration = duration + 1; // Extend booking duration by 1 hour
                    break;
                default: // Invalid package selection
                    System.out.println("Error");
            }
        }
        // Calculate total price if user does not purchase VIP
        else if (vipchoice == 0) {
            roomprice = modelprice() * times();
        }
        // Invalid VIP selection
        else {
            System.out.println("Error");
        }

        // Step 7: Print booking summary and total price
        System.out.println("Total Price of Private Room：" + roomprice);
        System.out.println("Duration：" + duration);
        System.out.println("Room Type：" + modelstring);
        System.out.println("Time：" + datestring + ", " + daystring + ", " + timestring);
    }

    /**
     * Get the calculated room price
     *
     * @return The room price
     */
    public double getroomprice() {
        return roomprice;
    }

    /**
     * Get the selected day string
     *
     * @return The day string
     */
    public String getDaystring() {
        return daystring;
    }

    /**
     * Get the entered date string
     *
     * @return The date string
     */
    public String getDatestring() {
        return datestring;
    }

    /**
     * Get the selected time period string
     *
     * @return The time period string
     */
    public String getTimestring() {
        return timestring;
    }

    /**
     * Get the selected room model string
     *
     * @return The room model string
     */
    public String getModelstring() {
        return modelstring;
    }

    /**
     * Get the booking duration
     *
     * @return The booking duration
     */
    public double getDuration() {
        return duration;
    }
}