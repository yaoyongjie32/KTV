import java.util.Scanner;

public class Songinput {
    int count;
    String[] songlibrary = new String[50];
    Scanner sc = new Scanner(System.in); // 全局Scanner，全程复用

    public void songinput() {
        System.out.println("====== Welcome to the song choosing system ======");
        System.out.println("Enter 0 to exit, Enter 1 to continue:");
        int answer1 = sc.nextInt();
        sc.nextLine(); // Absorb the newline character after nextInt()
        count = 1; // Initialize song count

        if (answer1 == 1) {
            System.out.println("Request a song:");
            String songname = sc.nextLine();
            songlibrary[0] = songname; // Store the first song

            // Loop to enter subsequent songs, maximum 50 songs
            while (count < 50) {
                System.out.println("Continue or not(0/1):");
                int answer2 = sc.nextInt();
                sc.nextLine(); // Absorb the newline character

                if (answer2 == 1) {
                    System.out.println("Request the next song:");
                    songname = sc.nextLine();
                    songlibrary[count] = songname; // Store the currently entered song
                    count++; // Increment song count
                } else {
                    System.out.println("Exit");
                    break; // Break the loop and end input
                }
            }
        } else {
            System.out.println("Exit");
        }

        // If songs are entered, call the fuzzy search method; otherwise, prompt that search is unavailable
        if (count > 0) {
            fuzzySearch();
        } else {
            System.out.println("No songs were entered, search is unavailable");
        }
    }

    // Fuzzy search method for songs
    public void fuzzySearch() {
        System.out.println("\n====== Song Fuzzy Search ======");
        System.out.println("Enter the keyword to search:");
        String searching = sc.nextLine(); // Get the search keyword entered by the user

        boolean hasMatch = false; // Flag to mark if matching songs are found
        System.out.println("====== Search Results ======");

        // Traverse all entered songs for fuzzy matching
        for (int i = 0; i < count; i++) {
            String song = songlibrary[i];
            // Core logic of fuzzy matching: Convert to lowercase uniformly to judge if it contains the keyword, avoiding case sensitivity
            if (song.toLowerCase().contains(searching.toLowerCase())) {
                System.out.println((i + 1) + ". " + song); // Output matched song
                hasMatch = true; // Mark that matching results are found
            }
        }

        // If no matching songs are found, prompt no results
        if (!hasMatch) {
            System.out.println("No songs found containing the keyword: " + searching);
        }
    }
}
