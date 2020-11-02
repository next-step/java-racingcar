package calculator.domain;

public class StringCalculator {
    private final double TOTAL;

    private StringCalculator(double total) {
        TOTAL = total;
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
        Calculator calculator = new Calculator();
        for (int i = 1; i < arrWord.length; i = i + 2) {
            String div = arrWord[i];
            calculator.setBeforeNum(i == 1 ? Double.parseDouble(arrWord[i - 1]) : total);
            calculator.setNextNum(Double.parseDouble(arrWord[i + 1]));
            total = calculator.calculate(div);
        }
        return total;
    }

    @Override
    public String toString() {
        return String.valueOf(TOTAL);
    }
}
