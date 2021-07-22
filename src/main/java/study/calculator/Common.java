package study.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Common {

    private static final Random random = new Random();

    private static final int LIMIT_NUMBER = 4;

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
        List<String> wordList = new ArrayList<>();

        Scanner scanner = new Scanner(input);

        while (scanner.hasNext()){
            String word = scanner.next();
            wordList.add(word);
        }
        scanner.close();
        return wordList;
    }

    public static String inputValue() {

        Scanner scanner = new Scanner(System.in);

        String word =  scanner.nextLine();

        scanner.close();

        return word;
    }

    public static int toInt(String value) {
        return Integer.parseInt(value);
    }

    public static int createRandomNumber(){
        return random.nextInt(10);
    }

    public static Boolean checkMoveable(int targetNumber) {
        return targetNumber >= LIMIT_NUMBER;
    }


    public static void drawDisplay(int moveDistance) {
        StringBuffer carModel = new StringBuffer();

        for(int i = 0; i < moveDistance; i++){
            carModel.append("-");
        }

        System.out.println("start|" + carModel);

    }
}
