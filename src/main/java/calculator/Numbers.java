package calculator;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private static final String WRONG_INPUT = "입력값이 잘못되었습니다.";
    private final List<Integer> numbers = new ArrayList<>();

    public Numbers(String[] inputArray) {
        for (int i = 0; i < inputArray.length; i += 2) {
            String input = inputArray[i];
            isNotConvertToInt(input);
            numbers.add(Integer.parseInt(input));
        }
    }

    public int get(int index) {
        return numbers.get(index);
    }

    private static void isNotConvertToInt(String input) {
        if (!Character.isDigit(input.charAt(0))) {
            throw new IllegalArgumentException(WRONG_INPUT);
        }
    }
}
