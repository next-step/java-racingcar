package calculator;

public class StringCalculator {

    private String text;

    public StringCalculator(String text) {
        this.text = text;
    }

    public int splitAndSum() {
        if (text == null || text.isBlank())
            return 0;

        Splitter splitter = new Splitter(text);
        int[] numbers = splitter.split();

        Calculator calculator = new Calculator(numbers);
        int sum = calculator.sum();
        return sum;
    }
}
