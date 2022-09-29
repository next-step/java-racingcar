package step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

        return Arrays.stream(stringNumbers)
                .map(str -> new Positive(Integer.parseInt(str)))
                .collect(Collectors.toList());
    }

    public int sum(List<Positive> numbers) {
        return numbers.stream()
                .reduce((a, b) -> a.plus(b))
                .map(Positive::getNumber)
                .orElse(0);
    }

    private int parseOne(String text) {
        return new Positive(text).getNumber();
    }
}
