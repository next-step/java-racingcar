package calculator;

public class InputValidUtil {
    private static final String WRONG_INPUT = "입력값이 잘못되었습니다.";

    public static void numbersValidation(String[] inputArray) {
        if (isEmpty(inputArray) || isNotAble(inputArray)) {
            throw new IllegalArgumentException(WRONG_INPUT);
        }
    }

    public static void isNull(String input) {
        if(input == null || input.isEmpty()) {
            throw new IllegalArgumentException(WRONG_INPUT);
        }
    }

    private static boolean isEmpty(String[] inputArray) {
        return inputArray.length == 0;
    }

    private static boolean isNotAble(String[] inputArray) {
        return inputArray.length % 2 == 0;
    }
}
