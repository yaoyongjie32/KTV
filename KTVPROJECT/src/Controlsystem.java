import java.util.Scanner;
import java.util.Random;

// Main class for lighting control system
public class Controlsystem {
    // Declare Random object to generate random numbers for lighting/style selection
    Random r = new Random();
    // Boolean variable to control the loop of lighting type selection (true = continue, false = terminate)
    boolean answer = true;
    // Flag variable to receive user input for continuing to select other lighting effects (0/1)
    int flag = 0;
    // Store the number of lighting type selected by user (1-6)
    int lightchoice;
    // String to concatenate the description of selected lighting types
    String lightstring = " ";
    // Store the number of style selected by user (1-4)
    int stylechoice;
    // String to concatenate the description of selected style
    String stylestring = " ";


    public void controlsystem(int vipChoice) { // Receive VIP selection parameter
        // Define array for lighting types, store English descriptions of 6 optional lighting effects
        String[] lighttype = new String[6];
        lighttype[0] = "Colorful LED Rain Light Effect";
        lighttype[1] = "Mirror Ball Reflection Effect";
        lighttype[2] = "Laser Light Effect";
        lighttype[3] = "Strobe Light Effect";
        lighttype[4] = "LED Strip Light Effect";
        lighttype[5] = "Moving Head Light Effect";

        // Define array for styles, store English descriptions of 4 optional lighting styles
        String[] style = new String[4];
        style[0] = "Soft";
        style[1] = "Bright";
        style[2] = "Dynamic";
        style[3] = "Dim";

        // Judge according to VIP selection
        if (vipChoice == 0) { // Non-VIP user: system randomly assigns lighting and style
            // Generate random number (1-6) corresponding to 6 lighting types
            lightchoice = r.nextInt(6) + 1;
            // Concatenate the description of randomly selected lighting type
            lightstring = lightstring + lighttype[lightchoice-1];
            // Generate random number (1-4) corresponding to 4 lighting styles
            stylechoice = r.nextInt(4) + 1;
            // Concatenate the description of randomly selected style
            stylestring = stylestring + style[stylechoice-1];
            // Output the result of randomly assigned lighting configuration
            System.out.println("The system will randomly assign lighting for you：" + lightstring + " " + stylestring);
        }
        else if (vipChoice == 1) { // VIP user: allow free selection of lighting and style
            // Create Scanner object to receive user input from console
            Scanner sc = new Scanner(System.in);

            // Loop for selecting lighting types (support multiple selections) until user terminates (flag=0 or input error)
            while (answer == true) {
                // Prompt user to enter the number of desired light effect
                System.out.println("Please enter the desired light effect ，1 2 3 4 5 6 are respectively：");
                // Print the number and description of 6 lighting types
                System.out.println("1." + lighttype[0] + "  2." + lighttype[1] + "  3." +
                        lighttype[2] + "  4." + lighttype[3] + "  5." +
                        lighttype[4] + "  6." + lighttype[5]);
                // Receive the lighting number entered by user
                lightchoice = sc.nextInt();
                // Check if the entered lighting number is within valid range (1-6)
                if(lightchoice >= 1 && lightchoice <= 6) {
                    // Concatenate the description of selected lighting type (add space to separate multiple selections)
                    lightstring = lightstring + lighttype[lightchoice-1] + " ";
                    // Prompt user whether to select other light effects (0 = no, 1 = yes)
                    System.out.println("Do you need to turn on any other light effects?（0/1）：");
                    // Receive user's selection flag
                    flag = sc.nextInt();
                    // If input is 0, terminate the lighting selection loop
                    if (flag == 0) {
                        answer = false;
                    } else if (flag == 1) { // If input is 1, continue the lighting selection loop
                        answer = true;
                    } else { // If input is not 0/1, regard as error, terminate loop and prompt
                        answer = false;
                        System.out.println("Input error. Selection terminated.");
                    }
                } else { // If lighting number is out of 1-6 range, prompt invalid selection
                    System.out.println("Invalid selection. Please enter a number between 1 and 6");
                }
            }

            // After selecting lighting types, prompt user to enter the number of desired style
            System.out.println("Please enter the desired type，1 2 3 4 are respectively：");
            // Print the number and description of 4 styles
            System.out.println("1." + style[0] + "  2." + style[1] + "  3." +
                    style[2] + "  4." + style[3]);
            // Receive the style number entered by user
            stylechoice = sc.nextInt();
            // Check if the entered style number is within valid range (1-4)
            if(stylechoice >= 1 && stylechoice <= 4) {
                // Concatenate the description of selected style
                stylestring = stylestring + style[stylechoice-1];
            } else { // If style number is out of range, prompt invalid selection and apply soft mode by default
                System.out.println("Invalid selection. Soft mode will be applied by default.");
                stylestring = stylestring + style[0];
            }
            // Output the final lighting configuration selected by user (lighting types + style)
            System.out.println("The lighting configuration you selected：" + lightstring + "+ " + stylestring);
        } else { // If VIP selection parameter is not 0/1, prompt VIP status error
            System.out.println("VIP status error");
        }
    }
}
