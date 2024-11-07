import java.util.Scanner;

public class SafeInput {

    public static int getRangedInt(Scanner console, String prompt, int low, int high) {
        int input;
        do {
            System.out.print(prompt);
            while (!console.hasNextInt()) {
                console.next();
                System.out.print(prompt);
            }
            input = console.nextInt();
            console.nextLine(); // Consume the newline character
        } while (input < low || input > high);
        return input;
    }

    public static boolean getYNConfirm(Scanner console, String prompt) {
        String response;
        do {
            System.out.print(prompt);
            response = console.nextLine().trim().toLowerCase();
        } while (!response.equals("y") && !response.equals("n"));
        return response.equals("y");
    }

    public static String getRegExString(Scanner console, String prompt, String regEx) {
        String response;
        do {
            System.out.print(prompt);
            response = console.nextLine().trim();
        } while (!response.matches(regEx));
        return response;
    }

    public static String getString(Scanner console, String prompt) {
        System.out.print(prompt);
        return console.nextLine().trim();
    }
}
