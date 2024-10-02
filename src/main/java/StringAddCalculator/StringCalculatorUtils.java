package StringAddCalculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculatorUtils {

    private static final String DELEMETER = ",|:";

    public static String[] splitStringCalculator(String inputs) {
        String splitedString = inputs;
        String currentDelimeter = DELEMETER;

        if (inputs.startsWith("//")) {
            int separatorIndex = inputs.indexOf("\n");
            currentDelimeter = inputs.substring(2, separatorIndex);  // 사용자 정의 구분자를 currentDelimeter에 저장
            splitedString = inputs.substring(separatorIndex + 1);
        }

        return splitedString.split(currentDelimeter);

    }
    public static List<Integer> convertInputs(String[] inputs) {
        List<Integer> result = new ArrayList<>();
        for (String input : inputs) {
            int number = toPositiveInteger(input);
            result.add(number);
        }
        return result;
    }

    private static int toPositiveInteger(String input) {
        int number = Integer.parseInt(input);
        if (number < 0) {
            throw new IllegalArgumentException("There is wrong value included: " + input);
        }
        return number;
    }


}