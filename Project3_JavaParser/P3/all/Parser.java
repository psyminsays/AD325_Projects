package all;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Parser {
    private final List<String> reservedWordsList; // List to store the reserved words
    private final Set<String> identifiersSet;     // Set to store the user-defined identifiers

    // Constructor to initialize reserved words from a file
    public Parser(String reservedWordsFile) {
        reservedWordsList = new ArrayList<>();
        identifiersSet = new HashSet<>();
        initializeReservedWords(reservedWordsFile);
    }

    // Method to initialize reserved words from a file
    public void initializeReservedWords(String reservedWordsFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(reservedWordsFile))) {
            String word;
            while ((word = reader.readLine()) != null) {
                word = word.trim();
                reservedWordsList.add(word);  // Add each reserved word to the list
            }
            // After inserting all words into the list, convert it to a balanced BST
            setBalancedBST(reservedWordsList);
        } catch (IOException e) {
            System.out.println(STR."Error reading reserved words file: \{e.getMessage()}");
        }
    }

    // Method to set a balanced BST from the list of reserved words
    public void setBalancedBST(List<String> list) {
        // Convert the list to a balanced binary search tree (BST)
        Collections.sort(list);  // Sort the list to simulate an ordered BST
    }

    // Method to extract identifiers from a Java program and add them to the identifiers set
    public void getIdentifiers(String javaProgram) {
        // Regular expression to match valid Java identifiers
        String regex = "\\b[A-Za-z_][A-Za-z0-9_]*\\b";

        // Use Pattern and Matcher to find all identifiers in the Java program
        Matcher matcher = Pattern.compile(regex).matcher(javaProgram);
        while (matcher.find()) {
            String identifier = matcher.group();

            // Exclude reserved words and avoid duplicates
            if (!reservedWordsList.contains(identifier)) {
                identifiersSet.add(identifier);
            }
        }

        // Print reserved words
        System.out.println("Reserved Words Found:");
        for (String word : reservedWordsList) {
            System.out.println(word);
        }

        // Print identifiers
        System.out.println("\nUser-Defined Identifiers Found:");
        for (String identifier : identifiersSet) {
            System.out.println(identifier);
        }
    }
}
