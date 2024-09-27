package calculator;

public class Calculator {

    public static int calculate(String targetString) {
        int targetNumber = Integer.parseInt(targetString);
        checkMinus(targetNumber);
        return targetNumber;
    }

    private static void checkMinus(int targetNumber) {
        if (targetNumber < 0) {
            throw new RuntimeException();
        }
    }

}
