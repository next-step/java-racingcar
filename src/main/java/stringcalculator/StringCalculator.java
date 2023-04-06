package stringcalculator;

public class StringCalculator {
    private final Numbers numbers;

    public StringCalculator(String text) {
        this.numbers = Numbers.of(text, Delimiters.of(text));
    }

    public int sum() {
        return numbers.sum();
    }
}
