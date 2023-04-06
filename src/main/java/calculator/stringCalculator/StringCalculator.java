package calculator.stringCalculator;


import java.util.List;

public class StringCalculator {
    private StringSeparator separator;

    private StringCalculator(StringSeparator separator) {
        this.separator = separator;
    }

    public static StringCalculator from(StringSeparator separator) {
        return new StringCalculator(separator);
    }

    public int calculate(String expression) {
        List<Integer> separate = separator.separate(expression);
        return separate.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

}
