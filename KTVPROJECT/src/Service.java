import java.util.Scanner;

/**
 * Service class handles beverage and snack ordering functionality in the KTV system.
 * It manages the ordering process, pricing, and VIP discount calculations.
 */
public class Service {
    // Beverage order choice (1-13 corresponding to different beverages)
    private int beveragechoice;
    // Snack order choice (1-6 corresponding to different snacks)
    private int snackchoice;
    // Choice for beverage need (0=No, 1=Yes)
    private int beverageneedchoice;
    // Choice for snack need (0=No, 1=Yes)
    private int snackneedchoice;
    // String to record ordered beverage names
    private String beveragestring = "  ";
    // String to record ordered snack names
    private String snackstring = " ";
    // Quantity of current beverage order
    private int beveragesum;
    // Quantity of current snack order
    private int snacksum;
    // Accumulated total quantity of all ordered beverages
    private int beverageaccumulator = 0;
    // Accumulated total quantity of all ordered snacks
    private int snackaccumulator = 0;
    // Flag to control beverage order loop (true=continue ordering, false=stop)
    private boolean answer1 = true;
    // Input flag for additional beverage needs (0=No, 1=Yes)
    private int flag1 = 0;
    // Flag to control snack order loop (true=continue ordering, false=stop)
    private boolean answer2 = true;
    // Input flag for additional snack needs (0=No, 1=Yes)
    private int flag2 = 0;
    // Total price of all ordered beverages (before VIP discount)
    private double beverageprice = 0;
    // Total price of all ordered snacks (before VIP discount)
    private double snackprice = 0;
    // Unit price of selected beverage (varies by beverage type)
    private int unitbeverageprice = 0;
    // Unit price of selected snack (varies by snack type)
    private int unitsnackprice = 0;
    // Total price of beverage + snack services (after VIP discount)
    private double serviceprice;
    // Store VIP selection status (1=VIP user, 0=non-VIP, -1=initial/invalid)
    private int vipChoice = -1;

    /**
     * Handle beverage and snack ordering process
     *
     * @param vipChoice The VIP status of the user (1 for VIP, 0 for non-VIP)
     */
    public void beverage(int vipChoice) {
        // Assign VIP status to class member variable
        this.vipChoice = vipChoice;
        // Define beverage type array (13 types, index 0-12 corresponding to choice 1-13)
        String[] beveragetype = new String[13];
        beveragetype[0] = "Beer";
        beveragetype[1] = "Vodka";
        beveragetype[2] = "Red Wine";
        beveragetype[3] = "Champagne";
        beveragetype[4] = "Sake";
        beveragetype[5] = "Fruit Wine";
        beveragetype[6] = "Flower Tea";
        beveragetype[7] = "Mineral Water";
        beveragetype[8] = "Cola";
        beveragetype[9] = "Sprite";
        beveragetype[10] = "Orange Juice";
        beveragetype[11] = "Wangzai Milk";
        beveragetype[12] = "Coffee";

        // Define snack type array (6 types, index 0-5 corresponding to choice 1-6)
        String[] snacktype = new String[6];
        snacktype[0] = "Popcorn";
        snacktype[1] = "Potato Chips";
        snacktype[2] = "Sunflower Seeds";
        snacktype[3] = "Pistachios";
        snacktype[4] = "Raisins";
        snacktype[5] = "Dried Mango";

        // Step 1: Check if guest needs beverages
        System.out.println("Need beverages or not (0/1)");
        Scanner sc = new Scanner(System.in);
        beverageneedchoice = sc.nextInt();

        // If guest needs beverages (choice=1)
        if (beverageneedchoice == 1) {
            // Loop for multiple beverage ordering (until guest selects no more)
            while (answer1 == true) {
                // Display beverage menu with price (1-13 correspond to beverage types and prices)
                System.out.println("Please enter the beverage you want to order: 1 correspond to " + beveragetype[0] + " 35yuan");
                System.out.println("enter: 2 correspond to " + beveragetype[1] + " 980yuan");
                System.out.println("enter: 3 correspond to " + beveragetype[2] + " 328yuan");
                System.out.println("enter: 4 correspond to " + beveragetype[3] + " 900yuan");
                System.out.println("enter: 5 correspond to " + beveragetype[4] + " 170yuan");
                System.out.println("enter: 6 correspond to " + beveragetype[5] + " 25yuan");
                System.out.println("enter: 7 correspond to " + beveragetype[6] + " 18yuan");
                System.out.println("enter: 8 correspond to " + beveragetype[7] + " 3yuan");
                System.out.println("enter: 9 correspond to " + beveragetype[8] + " 4yuan");
                System.out.println("enter: 10 correspond to " + beveragetype[9] + " 4yuan");
                System.out.println("enter: 11 correspond to " + beveragetype[10] + " 38yuan");
                System.out.println("enter: 12 correspond to " + beveragetype[11] + " 25yuan");
                System.out.println("enter: 13 correspond to " + beveragetype[12] + " 7yuan");

                // Get guest's beverage choice (1-13)
                beveragechoice = sc.nextInt();

                // Set unit price based on selected beverage
                switch (beveragechoice) {
                    case 1:
                        unitbeverageprice = 35;
                        break;
                    case 2:
                        unitbeverageprice = 980;
                        break;
                    case 3:
                        unitbeverageprice = 328;
                        break;
                    case 4:
                        unitbeverageprice = 900;
                        break;
                    case 5:
                        unitbeverageprice = 170;
                        break;
                    case 6:
                        unitbeverageprice = 25;
                        break;
                    case 7:
                        unitbeverageprice = 18;
                        break;
                    case 8:
                        unitbeverageprice = 3;
                        break;
                    case 9:
                        unitbeverageprice = 4;
                        break;
                    case 10:
                        unitbeverageprice = 4;
                        break;
                    case 11:
                        unitbeverageprice = 38;
                        break;
                    case 12:
                        unitbeverageprice = 25;
                        break;
                    case 13:
                        unitbeverageprice = 7;
                        break;
                }

                // Get quantity of selected beverage
                System.out.println("Please enter the quantity：");
                beveragesum = sc.nextInt();

                // Accumulate total beverage quantity and price
                beverageaccumulator = beverageaccumulator + beveragesum;
                beverageprice = beverageprice + beveragesum * unitbeverageprice;

                // Record ordered beverage name (adjust index: choice-1 = array index)
                beveragestring = beveragestring + " " + beveragetype[beveragechoice - 1];

                // Check if guest needs more beverages
                System.out.println("Any other beverage needs (0/1) ：");
                flag1 = sc.nextInt();

                // Update loop flag based on guest's choice
                if (flag1 == 0) {
                    answer1 = false; // Stop beverage ordering
                } else if (flag1 == 1) {
                    answer1 = true; // Continue ordering
                } else {
                    answer1 = false;
                    System.out.println("Error");
                }
            }

            // Display beverage order summary
            System.out.println("Beverages You Ordered：" + beveragestring);
            System.out.println("Quantity：" + beverageaccumulator);
            System.out.println("Please select the next item：");
        }
        // If guest doesn't need beverages (choice=0)
        else if (beverageneedchoice == 0) {
            System.out.println("Please select the next item");
        }
        // Invalid input (not 0/1)
        else {
            System.out.println("Error");
        }

        // Step 2: Check if guest needs snacks
        System.out.println("Need snacks or not (0/1)");
        snackneedchoice = sc.nextInt();

        // If guest needs snacks (choice=1)
        if (snackneedchoice == 1) {
            // Loop for multiple snack ordering (until guest selects no more)
            while (answer2 == true) {
                // Display snack menu with price (1-6 correspond to snack types and prices)
                System.out.println("Please enter the beverage you want to order: 1 correspond to " + snacktype[0] + "15yuan");
                System.out.println("enter: 2 correspond to " + snacktype[1] + " 10yuan");
                System.out.println("enter: 3 correspond to " + snacktype[2] + " 10yuan");
                System.out.println("enter: 4 correspond to " + snacktype[3] + " 30yuan");
                System.out.println("enter: 5 correspond to " + snacktype[4] + " 17yuan");
                System.out.println("enter: 6 correspond to " + snacktype[5] + " 22yuan");

                // Get guest's snack choice (1-6)
                snackchoice = sc.nextInt();

                // Set unit price based on selected snack
                switch (snackchoice) {
                    case 1:
                        unitsnackprice = 15;
                        break;
                    case 2:
                        unitsnackprice = 10;
                        break;
                    case 3:
                        unitsnackprice = 10;
                        break;
                    case 4:
                        unitsnackprice = 30;
                        break;
                    case 5:
                        unitsnackprice = 17;
                        break;
                    case 6:
                        unitsnackprice = 22;
                        break;
                }

                // Get quantity of selected snack
                System.out.println("Please enter the quantity：");
                snacksum = sc.nextInt();

                // Accumulate total snack quantity and price
                snackaccumulator = snackaccumulator + snacksum;
                snackprice = snackprice + snacksum * unitsnackprice;

                // Record ordered snack name (adjust index: choice-1 = array index)
                snackstring = snackstring + " " + snacktype[snackchoice - 1];

                // Check if guest needs more snacks
                System.out.println("Any other beverage needs (0/1)：");
                flag2 = sc.nextInt();

                // Update loop flag based on guest's choice
                if (flag2 == 0) {
                    answer2 = false; // Stop snack ordering
                } else if (flag2 == 1) {
                    answer2 = true; // Continue ordering
                } else {
                    answer2 = false; // Invalid input, stop ordering
                    System.out.println("Error");
                }
            }

            // Display snack order summary
            System.out.println("Snacks You Ordered：" + snackstring);
            System.out.println("Quantity：" + snackaccumulator);
            System.out.println("Thank you for your patronage");
        }
        // If guest doesn't need snacks (choice=0)
        else if (snackneedchoice == 0) {
            // Invalid input (not 0/1)
            System.out.println("Thank you for your patronage");
        }
        // Step 3: Apply VIP privilege rule
        else {
            System.out.println("Error");
        }

        // Apply VIP privilege rule
        if (vipChoice == 0) { // Non-VIP user: no discount, original price applies
            beverageprice = beverageprice + 0;
            snackprice = snackprice + 0;
        } else if (vipChoice == 1) { // VIP user: beverages and snacks are free
            beverageprice = 0;
            snackprice = 0;
        }

        // Calculate total service price (beverage + snack after VIP discount)
        serviceprice = snackprice + beverageprice;

        // Display total price of beverages and snacks
        System.out.println("Total Price of Beverages and Snacks：" + serviceprice);
    }

    /**
     * Get the calculated service price
     *
     * @return The service price
     */
    public double getserviceprice() {
        return serviceprice;
    }
}