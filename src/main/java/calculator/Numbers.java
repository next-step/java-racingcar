package calculator;

import java.util.ArrayList;
import java.util.List;

public class Numbers extends InputValid {
    private static final String WRONG_INPUT = "입력값이 잘못되었습니다.";
    private final List<Integer> numbers = new ArrayList<>();

    public Numbers(String[] inputArray) {
        numbersValidation(inputArray);
        for (int i = 0; i < inputArray.length; i += 2) {
            numbers.add(Integer.parseInt(inputArray[i]));
        }
    }

    public int get(int index) {
        return numbers.get(index);
    }

    private void numbersValidation(String[] input) {
        if (isNull(input) || isEmpty(input) ||
            isNotConvertToInt(input) || isNotAble(input)) {
            throw new IllegalArgumentException(WRONG_INPUT);
        }
    }

    private static boolean isNotConvertToInt(String[] inputArray) {
        for (int i = 0; i < inputArray.length; i += 2) {
            if(!Character.isDigit(inputArray[i].charAt(0))){
                return true;
            }
        }
        return false;
    }
}
