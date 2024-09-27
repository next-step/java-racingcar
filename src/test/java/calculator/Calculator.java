package calculator;

public class Calculator {

    public static int calculate(String targetString) {
        if (isDelimiter(targetString)) {
            String[] splitStringArray = targetString.split("[;,]");
            return loopAndAdd(splitStringArray);
        }
        return Integer.parseInt(targetString);
    }

    private static int loopAndAdd(String[] splitStringArray) {
        int result = 0;
        for (String addNumber : splitStringArray) {
            validate(addNumber);
            result += Integer.parseInt(addNumber);
        }
        return result;
    }

    private static boolean isDelimiter(String targetString) {
        return targetString.contains(",") || targetString.contains(";");
    }

    private static void validate(String targetString) {
        try {
            int number = Integer.parseInt(targetString);
            validateMinus(number);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닌 값이거나 음수입니다.");
        }
    }

    private static void validateMinus(int targetNumber) {
        if (targetNumber < 0) {
            throw new RuntimeException("연산 대상 숫자가 음수입니다.");
        }
    }
}
