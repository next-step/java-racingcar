package study.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Common {
    public static void checkValue(String input) {
        if (input == null || input.trim().isEmpty()) {
            System.out.println("input Value is null or blank");
            throw new IllegalArgumentException("input Value is null or blank");
        }
    }

    public static void checkOperation(String operation) {
        if (isaBoolean(operation)) {
            System.out.println("input operation is wrong");
            throw new IllegalArgumentException("input operation is wrong");
        }

    }

    private static boolean isaBoolean(String operation) {
        return !operation.contains("+") ||
               !operation.contains("-") ||
               !operation.contains("*") ||
               !operation.contains("/");
    }

    public static List<String> inputSplitValue(String input) {
        Scanner scanner = new Scanner(input);
        List<String> wordList = new ArrayList<>();

        while (scanner.hasNext()){
            String word = scanner.next();
            wordList.add(word);
        }
        return wordList;
    }
}
