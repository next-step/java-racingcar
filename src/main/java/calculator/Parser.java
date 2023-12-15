package calculator;

import java.util.Arrays;
import java.util.List;

public final class Parser {
    public int[] parseInts(List<String> numbers){
        System.out.println(numbers);
        int[] intArray = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            int number = parseInt(numbers.get(i));
            intArray[i] = number;
        }
        return intArray;
    }

    private int parseInt(String number){
        try {
            return checkBlank(number);
        } catch (NumberFormatException exception){
            throw new NumberFormatException(number + "은 숫자가 아닌 문자입니다.");
        }
    }

    private int checkBlank(String number){
        if(number.equals(" ")){
            return 0;
        }
        return Integer.parseInt(number);
    }
}
