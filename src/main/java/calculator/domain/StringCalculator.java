package calculator.domain;

public class StringCalculator {
    private final double TOTAL;

    private StringCalculator(double total) {
        this.TOTAL = total;
    }

    public static StringCalculator of(String inputWord) {
        validInputWord(inputWord);
        double total = calculate(splitWord(inputWord));
        return new StringCalculator(total);
    }

    static void validInputWord(String inputWord) {
        if ("".equals(inputWord) || inputWord == null) {
            throw new IllegalArgumentException();
        }
    }

    static String[] splitWord(String inputWord) {
        return inputWord.split(" ");
    }

    static double calculate(String[] arrWord) {
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
