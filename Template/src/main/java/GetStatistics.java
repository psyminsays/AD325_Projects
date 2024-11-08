import java.util.Random;

public class GetStatistics {

    public static void main(String[] args) {
        int[] nameCounts = {1000, 10000};
        for (int count : nameCounts) {
            System.out.println("Running test for " + count + " names...");

            // Generating random names
            String[] randomNames = generateRandomNames(count);

            // Test Double Hashing
            DictionaryInterface<String, Integer> doubleHashingDict = new DoubleHashingWithCount<>();
            long startTime = System.nanoTime();
            for (String name : randomNames) {
                doubleHashingDict.add(name, name.length());
            }
            long endTime = System.nanoTime();
            System.out.println("Double Hashing: " + (endTime - startTime) / 1000000.0 + " ms");

            // Test Linear Probing
            DictionaryInterface<String, Integer> linearProbingDict = new LinearProbingWithCount<>();
            startTime = System.nanoTime();
            for (String name : randomNames) {
                linearProbingDict.add(name, name.length());
            }
            endTime = System.nanoTime();
            System.out.println("Linear Probing: " + (endTime - startTime) / 1000000.0 + " ms");
        }
    }

    private static String[] generateRandomNames(int count) {
        String[] names = new String[count];
        Random rand = new Random();
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < count; i++) {
            StringBuilder sb = new StringBuilder();
            int nameLength = rand.nextInt(5) + 5;  // Random name length between 5 and 10
            for (int j = 0; j < nameLength; j++) {
                sb.append(chars.charAt(rand.nextInt(chars.length())));

            }
            names[i] = sb.toString();
        }
        return names;
    }
}