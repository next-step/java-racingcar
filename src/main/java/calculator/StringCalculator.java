package calculator;

public class StringCalculator implements DefaultCalculator {

    private String input;


    private StringCalculator(String input) {
        this.input = input;
    }

    public static StringCalculator of(String input) {
        return new StringCalculator(input);
    }

    private int calculate(String[] strings) {
        int number1 = Integer.parseInt(strings[0]);
        int number2 = Integer.parseInt(strings[2]);
        return add(number1, number2);
    }

    public int calculate() {
        return calculate(Splitter.of(this.input).splitByString());
    }
}
