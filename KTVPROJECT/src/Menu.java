import java.util.Scanner;

// Menu class: provides functions to display different types of information (date, time, room type, etc.)
public class Menu {
    // Array to store 7 days of the week (Monday to Sunday)
    public void getdaylist() {
        String[] daylist = new String[7];
        daylist[0] = "Monday";
        daylist[1] = "Tuesday";
        daylist[2] = "Wednesday";
        daylist[3] = "Thursday";
        daylist[4] = "Friday";
        daylist[5] = "Saturday";
        daylist[6] = "Sunday";
        // Loop through the array and print each day
        for (int i = 0; i < 7; i++) {
            System.out.println(daylist[i]);
        }
    }

    public void gettimelist() {
        // Array to store 4 business time periods
        String[] timelist = new String[4];
        timelist[0] = "9:00~12:00";
        timelist[1] = "12:00~17:00";
        timelist[2] = "17:00~21:00";
        timelist[3] = "21:00~9:00";
        // Loop through the array and print each time period
        for (int i = 0; i < 4; i++) {
            System.out.println(timelist[i]);
        }
    }

    public void getmodellist() {
        // Array to store 3 room types and their hourly prices
        String[] modellist = new String[3];
        modellist[0] = "Private Room: ¥60 per Hour";
        modellist[1] = "Medium Private Room: ¥80 per Hour";
        modellist[2] = "Large Private Room: ¥95 per Hour";
        // Loop through the array and print each room type & price
        for (int i = 0; i < 3; i++) {
            System.out.println(modellist[i]);
        }
    }

    public void getpackagelist() {
        // Array to store 2 membership packages (VIP/SVIP)
        String[] packagelist = new String[2];
        packagelist[0] = "VIP ¥79: 20% Off + Free Drinks + Partial Lighting Optional";
        packagelist[1] = "SVIP ¥149: 35% Off + 1 Extra Hour + Free Drinks + All Lighting Optional";
        // Loop through the array and print each package & privileges
        for (int i = 0; i < 2; i++) {
            System.out.println(packagelist[i]);
        }
    }

    public void getbeveragetype() {
        // Array to store 13 types of beverages
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
        // Loop through the array and print each beverage type
        for (int i = 0; i < 13; i++) {
            System.out.println(beveragetype[i]);
        }
    }

    public void getsnacktype() {
        // Array to store 6 types of snacks
        String[] snacktype = new String[6];
        snacktype[0] = "Popcorn";
        snacktype[1] = "Potato Chips";
        snacktype[2] = "Sunflower Seeds";
        snacktype[3] = "Pistachios";
        snacktype[4] = "Raisins";
        snacktype[5] = "Dried Mango";
        // Loop through the array and print each snack type
        for (int i = 0; i < 6; i++) {
            System.out.println(snacktype[i]);
        }
    }

    public void getlighttype() {
        String[] lighttype = new String[6];
        lighttype[0] = "Colorful LED Rain Light Effect";
        lighttype[1] = "Mirror Ball Reflection Effect";
        lighttype[2] = "Laser Light Effect";
        lighttype[3] = "Strobe Light Effect";
        lighttype[4] = "LED Strip Light Effect";
        lighttype[5] = "Moving Head Light Effect";
        // Array to store 6 types of light effects
        for (int i = 0; i < 6; i++) {
            System.out.println(lighttype[i]);
        }
    }

    public void getstyle() {
        // Array to store 4 light & shadow atmosphere styles
        String[] style = new String[4];
        style[0] = "Soft";
        style[1] = "Bright";
        style[2] = "Dynamic";
        style[3] = "Dim";
        // Loop through the array and print each style
        for (int i = 0; i < 4; i++) {
            System.out.println(style[i]);
        }
    }

    public void menu() {
        // Create Scanner object to receive user input
        Scanner sc = new Scanner(System.in);
        // Print welcome message and menu prompt
        System.out.println("Welcome! The following is the menu：");
        // Infinite loop until user enters 0 to exit
        while (true) {
            // Print menu operation instructions
            System.out.println("Enter 1 2 3 4 5 6 7 8 respectively to" +
                    " display 1.Date 2.Time 3.Room Type 4.VIP 5.Package 6.Beverages 7.Snacks 8.Light Effects Light " +
                    "& Shadow Atmosphere (Enter 0 to exit the menu)");
            // Receive user's menu selection (integer 0-8)
            int menuchoice = sc.nextInt();
            // If user input is not 0, execute corresponding function
            if(menuchoice != 0){
                if (menuchoice == 1) {
                    // Display day list
                    getdaylist();
                }
                else if (menuchoice == 2) {
                    // Display time list
                    gettimelist();
                }
                else if (menuchoice == 3) {
                    // Display room type list
                    getmodellist();
                }
                else if (menuchoice == 4) {
                    // Display VIP package list
                    getpackagelist();
                }
                else if (menuchoice == 5) {
                    // Display beverage type list
                    getbeveragetype();
                }
                else if (menuchoice == 6) {
                    // Display snack type list
                    getsnacktype();
                }
                else if (menuchoice == 7) {
                    // Display light effect list
                    getlighttype();
                }
                else if (menuchoice == 8) {
                    // Display light style list
                    getstyle();
                }
            }
            // If user input is 0, exit the menu
            else{
                System.out.println("Menu exited");
                // Break the infinite loop
                break;
            }
        }
    }
}
