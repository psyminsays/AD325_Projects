package all;

public class Driver {
    public static void main(String[] args) {
        // Initialize Parser with a file containing reserved words
        String reservedWordsFile = "reservedWords.txt"; // path to your reserved words file
        Parser parser = new Parser(reservedWordsFile);

        // Sample Java program (string representation)
        String javaProgram = "public class Example { int a = 5; String b = \"Hello\"; }";

        // Parse the program to extract identifiers
        // This will print reserved words and identifiers
        parser.getIdentifiers(javaProgram);
    }
}
