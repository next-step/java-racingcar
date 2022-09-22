package step2;

import java.util.ArrayList;
import java.util.List;

public class StringAddCalculator {
    public int splitAndSum(String text) {
        CalculatorString calculatorString = CalculatorString.of(text);

        if (calculatorString.empty()) {
            return 0;
        }

        if (calculatorString.numeral()) {
            return parseOne(calculatorString.getText());
        }

        List<Integer> numbers = split(calculatorString.getText(), calculatorString.getDelimiter());

        return sum(numbers);
    }

    public List<Integer> split(String text, String delimiter) {
        String[] stringNumbers = text.split(delimiter);
        List<Integer> numbers = new ArrayList<>();

        for (String s : stringNumbers) {
            int num = Integer.parseInt(s);
            validateNumber(num);
            numbers.add(num);
        }

        return numbers;
    }

    public int sum(List<Integer> numbers) {
        int sum = 0;

        for (int n : numbers) {
            sum += n;
        }

        return sum;
    }

    private int parseOne(String text) {
        int num = Integer.parseInt(text);
        validateNumber(num);
        return num;
    }

    private void validateNumber(int num) {
        if (num < 0) {
            throw new RuntimeException("Negative number can't calculated.");
        }
    }
}
