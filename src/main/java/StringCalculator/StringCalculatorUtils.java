package StringCalculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculatorUtils {

    public static String[] splitStringCalculator(String inputs) {
        String DELEMETER = "[,:]";
        String splitedString ="";

        if (inputs.startsWith("//")) {
            int separatorIndex = inputs.indexOf("\n");
            DELEMETER = inputs.substring(2, separatorIndex);
            splitedString = inputs.substring(separatorIndex + 1);
        }

        return splitedString.split(DELEMETER);
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
            throw new RuntimeException("There is wrong value included: " + input);
        }
        return number;
    }


}
