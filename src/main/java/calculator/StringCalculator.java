package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    public static int calculator(String text) {
        List<String> values = Arrays.asList(text.split(" "));

        return calculatorResult(values);
    }

    public static int calculatorResult(List<String> values) {
        int first = Integer.parseInt(values.get(0));
        int second = Integer.parseInt(values.get(2));
        String operation = values.get(1);

        Integer result = oprationResult(first, second, operation);

        List<String> subValues = getSubValues(values, result);

        if(subValues.size() > 2)
            return calculatorResult(subValues);

        return result;
    }

    private static List<String> getSubValues(List<String> values, Integer result) {
        List<String> subValues = new ArrayList<>();
        subValues.add(0, result.toString());
        subValues.addAll(values.subList(3, values.size()));
        return subValues;
    }


    public static int oprationResult(int first, int second, String operation) {
        switch (operation) {
            case "+":
                return first + second;
            case "-":
                return first - second;
            case "*":
                return first * second;
            case "/":
                return first / second;
            default:
                throw new IllegalArgumentException();
        }
    }

}