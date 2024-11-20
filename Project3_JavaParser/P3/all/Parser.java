import java.io.*;
import java.util.*;

/**
 * The Parser class processes Java source code, extracting reserved words and identifiers.
 * It uses a balanced binary search tree (BST) to store and manage reserved words and identifiers.
 */
public class Parser {

    private Set<String> reservedWords;  // Set to store reserved words
    private BalancedBST<String> reservedWordsTree;  // BST for reserved words
    private BalancedBST<String> identifiersTree;  // BST for identifiers

    /**
     * Constructor for Parser. Initializes the data structures.
     */
    public Parser() {
        reservedWords = new HashSet<>();
        reservedWordsTree = new BalancedBST<>();
        identifiersTree = new BalancedBST<>();
    }

    /**
     * Reads reserved words from a file and inserts them into a balanced BST.
     *
     * @param filename The file containing reserved words.
     * @throws IOException If an error occurs while reading the file.
     */
    public void initializeReservedWords(String filename) throws IOException {
        // Read the reserved words from the file and add them to the set
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                reservedWords.add(line.trim());
            }
        }

        // Add reserved words to the BST
        for (String word : reservedWords) {
            reservedWordsTree.insert(word);
        }
    }

    /**
     * Extracts identifiers from Java source code and adds them to the identifiers BST.
     *
     * @param javaCode The Java source code to extract identifiers from.
     */
    public void getIdentifiers(String javaCode) {
        // Regular expression for Java identifiers
        String regex = "\\b([a-zA-Z_][a-zA-Z0-9_]*)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(javaCode);

        // Add valid identifiers to the identifiers BST
        while (matcher.find()) {
            String identifier = matcher.group(1);
            if (!reservedWords.contains(identifier)) {
                identifiersTree.insert(identifier);
            }
        }
    }

    /**
     * Returns the tree of reserved words.
     *
     * @return The BalancedBST holding reserved words.
     */
    public BalancedBST<String> getReservedWordsTree() {
        return reservedWordsTree;
    }

    /**
     * Returns the tree of identifiers.
     *
     * @return The BalancedBST holding identifiers.
     */
    public BalancedBST<String> getIdentifiersTree() {
        return identifiersTree;
    }
}
