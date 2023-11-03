package calculator;

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
        int num = parseInt(element);
        if (num < 0) {
            throw new RuntimeException();
        }
        return num;
    }

    public List<Integer> digits() {
        return this.calcNumbers;
    }
}
