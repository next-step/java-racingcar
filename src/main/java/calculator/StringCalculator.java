package calculator;

public class StringCalculator {

    private String input;


    private StringCalculator(String input) {
        this.input = input;
    }

    public static StringCalculator of(String input) {
        return new StringCalculator(input);
    }

    private Long calculate(String[] strings) {
        return Math.createMath(strings[1]).calculate(Long.parseLong(strings[0]), Long.parseLong((strings[2])));
    }

    public Long calculate() {
        return calculate(Splitter.of(this.input).splitByString());
    }
}
