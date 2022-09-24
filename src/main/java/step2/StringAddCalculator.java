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

        return sum(split(calculatorString.getText(), calculatorString.getDelimiter()));
    }

    public List<Positive> split(String text, String delimiter) {
        String[] stringNumbers = text.split(delimiter);
        List<Positive> numbers = new ArrayList<>();

        for (String s : stringNumbers) {
            numbers.add(new Positive(Integer.parseInt(s)));
        }

        return numbers;
    }

    public int sum(List<Positive> numbers) {
        Positive sum = new Positive(0);

        for (Positive n : numbers) {
            sum = sum.plus(n);
        }

        return sum.getNumber();
    }

    private int parseOne(String text) {
        return new Positive(text).getNumber();
    }
}
