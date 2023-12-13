package calculator;

import java.util.Arrays;

public class Parser {
    protected int[] parseInts(StringBuilder numbers){
        int[] intArray = new int[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            int number = parseInt(numbers.charAt(i));
            intArray[i] = number;
        }
        return intArray;
    }

    private int parseInt(char number){
        try {
            return checkBlank(number);
        } catch (NumberFormatException exception){
            throw new NumberFormatException("숫자가 아닌 문자가 있습니다.");
        }
    }

    private int checkBlank(char number){
        if(number == ' '){
            return 0;
        }
        return Character.getNumericValue(number);
    }
}
