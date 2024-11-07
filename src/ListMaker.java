import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {
    private static ArrayList<String> myList = new ArrayList<>();
    private static final Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        boolean keepGoing = true;

        while (keepGoing) {
            displayMenu();
            char choice = SafeInput.getRegExString(console, "Enter a command: [AaDdIiPpQq]", "[AaDdIiPpQq]").charAt(0);
            switch (Character.toLowerCase(choice)) {
                case 'a':
                    addItem();
                    break;
                case 'd':
                    deleteItem();
                    break;
                case 'i':
                    insertItem();
                    break;
                case 'p':
                    printList();
                    break;
                case 'q':
                    keepGoing = !SafeInput.getYNConfirm(console, "Are you sure you want to quit? (y/n): ");
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nMenu Options:");
        System.out.println("A - Add an item");
        System.out.println("D - Delete an item");
        System.out.println("I - Insert an item");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit the program");
    }

    private static void addItem() {
        String item = SafeInput.getString(console, "Enter the item to add: ");
        myList.add(item);
        System.out.println("Item added.");
    }

    private static void deleteItem() {
        if (myList.isEmpty()) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        printListWithNumbers();
        int index = SafeInput.getRangedInt(console, "Enter the number of the item to delete: ", 1, myList.size()) - 1;
        myList.remove(index);
        System.out.println("Item deleted.");
    }

    private static void insertItem() {
        if (myList.isEmpty()) {
            System.out.println("List is empty. Adding at the end.");
            addItem();
            return;
        }
        printListWithNumbers();
        int index = SafeInput.getRangedInt(console, "Enter the number where you want to insert the item: ", 1, myList.size() + 1) - 1;
        String item = SafeInput.getString(console, "Enter the item to insert: ");
        myList.add(index, item);
        System.out.println("Item inserted.");
    }

    private static void printList() {
        if (myList.isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        System.out.println("\nList:");
        for (String item : myList) {
            System.out.println("- " + item);
        }
    }

    private static void printListWithNumbers() {
        System.out.println("\nList:");
        for (int i = 0; i < myList.size(); i++) {
            System.out.println((i + 1) + ": " + myList.get(i));
        }
    }
}
