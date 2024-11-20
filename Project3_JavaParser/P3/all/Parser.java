import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Parser {
    private LinkedList reservedWordsList; // Linked list to store the reserved words
    private LinkedList identifiersList;   // Linked list to store the user-defined identifiers

    // Constructor to initialize reserved words from a file
    public Parser(String reservedWordsFile) {
        reservedWordsList = new LinkedList();
        identifiersList = new LinkedList();
        initializeReservedWords(reservedWordsFile);
    }

    // Method to initialize reserved words from a file
    public void initializeReservedWords(String reservedWordsFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(reservedWordsFile))) {
            String word;
            while ((word = reader.readLine()) != null) {
                word = word.trim();
                reservedWordsList.push(word);  // Add each reserved word to the list
            }
            // After inserting all words into the list, convert it to a balanced BST
            setBalancedBST(reservedWordsList);
        } catch (IOException e) {
            System.out.println("Error reading reserved words file: " + e.getMessage());
        }
    }

    // Method to set a balanced BST from the linked list of reserved words
    public void setBalancedBST(LinkedList list) {
        // Convert the linked list to a balanced binary search tree (BST)
        LinkedList.TNode root = list.sortedListToBST();
        list.setRoot(root); // Set the root of the list's tree
    }

    // Method to extract identifiers from a Java program and add them to the identifiers BST
    public void getIdentifiers(String javaProgram) {
        // Regular expression to match valid Java identifiers
        String regex = "\\b[A-Za-z_][A-Za-z0-9_]*\\b";
        Set<String> identifiers = new HashSet<>();

        // Use Pattern and Matcher to find all identifiers in the Java program
        Matcher matcher = Pattern.compile(regex).matcher(javaProgram);
        while (matcher.find()) {
            String identifier = matcher.group();

            // Exclude reserved words and avoid duplicates
            if (!reservedWordsList.contains(identifier)) {
                identifiers.add(identifier);
                identifiersList.push(identifier);  // Add identifier to the identifiers list
            }
        }

        // Print reserved words from the BST (in-order traversal)
        System.out.println("Reserved Words Found:");
        reservedWordsList.printList();

        // Print identifiers from the BST (in-order traversal)
        System.out.println("\nUser-Defined Identifiers Found:");
        identifiersList.printList();
    }
}
