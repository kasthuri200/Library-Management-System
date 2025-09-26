import java.io.*;
import java.util.Scanner;

public class NotesApp {
    private static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Notes App ---");
            System.out.println("1. Write a new note (overwrite file)");
            System.out.println("2. Append a note");
            System.out.println("3. Read all notes");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    writeNote(scanner, false); // overwrite mode
                    break;
                case 2:
                    writeNote(scanner, true); // append mode
                    break;
                case 3:
                    readNotes();
                    break;
                case 4:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    // Method to write note
    private static void writeNote(Scanner scanner, boolean append) {
        try (FileWriter writer = new FileWriter(FILE_NAME, append)) {
            System.out.print("Enter your note: ");
            String note = scanner.nextLine();
            writer.write(note + System.lineSeparator());
            System.out.println("Note saved successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while writing note: " + e.getMessage());
        }
    }

    // Method to read notes
    private static void readNotes() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\n--- Your Notes ---");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("------------------");
        } catch (FileNotFoundException e) {
            System.out.println("No notes found. Write a note first!");
        } catch (IOException e) {
            System.out.println("An error occurred while reading notes: " + e.getMessage());
        }
    }
}
