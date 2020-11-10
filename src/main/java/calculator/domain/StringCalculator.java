package calculator.domain;

import java.util.Objects;

public class StringCalculator {
    private static final String SPLIT_WORD = " ";

    private final double TOTAL;

    private StringCalculator(double total) {
        this.TOTAL = total;
    }

    public static StringCalculator of(String inputWord) {
        validInputWord(inputWord);
        double total = calculate(inputWord.split(SPLIT_WORD));
        return new StringCalculator(total);
    }

    private static void validInputWord(String inputWord) {
        if (Objects.isNull(inputWord) || inputWord.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private static double calculate(String[] arrWord) {
        double total = 0;
        for (int i = 1; i < arrWord.length; i = i + 2) {
            String sign = arrWord[i];
            double beforeNum = i == 1 ? Double.parseDouble(arrWord[i - 1]) : total;
            double nextNum = Double.parseDouble(arrWord[i + 1]);
            total = Operator.getOperator(sign).calculate(beforeNum, nextNum);
        }
        return total;
    }

    @Override
    public String toString() {
        return String.valueOf(TOTAL);
    }
}
