package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private String delimiter = "[,:]";

    public int sumAll(String input) {

        if (input.isBlank()) {
            return 0;
        }

        return getSum(makeStringToIntArray(delimiter, input));
    }

    private List<Integer> makeStringToIntArray(String delimiter, String input) {
        String[] stringNumbers = input.split(delimiter);

        List<Integer> numbers = new ArrayList<>();
        for (String stringNumber : stringNumbers) {
            numbers.add(Integer.parseInt(stringNumber));
        }

        return numbers;
    }

    private int getSum(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
}
