package calculator;

import calculator.exception.NegativeNumberException;
import calculator.exception.NotNumberException;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class CalcNumbers {
    private final List<Integer> calcNumbers;

    public CalcNumbers(List<String> elements) {
        this.calcNumbers = elements.stream()
                .map(this::convert).collect(Collectors.toList());
    }

    private int convert(String element) {
        int num = convertInteger(element);
        checkMinus(num);
        return num;
    }

    private int convertInteger(String element) {
        try {
            return parseInt(element);
        } catch (NumberFormatException e) {
            throw new NotNumberException();
        }
    }

    private void checkMinus(int num) {
        if (num < 0) {
            throw new NegativeNumberException();
        }
    }


    public List<Integer> digits() {
        return this.calcNumbers;
    }
}
