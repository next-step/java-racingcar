package calculator;

import java.util.Arrays;
import java.util.LinkedList;

public class StringCalculator {

    private String input;


    private StringCalculator(String input) {
        this.input = input;
    }

    public static StringCalculator of(String input) {
        return new StringCalculator(input);
    }


    private Long calculate(String[] strings) {

        LinkedList<String> input = new LinkedList<>(Arrays.asList(strings));


        while (input.size() > 1) {
            String firstArg = input.pop();
            String expression = input.pop();
            String thirdArg = input.pop();
            input.addFirst(Math.createMath(expression).calculate(Long.parseLong(firstArg), Long.parseLong(thirdArg)).toString());
        }

        return Long.parseLong(input.pop());
    }


    public Long calculate() {
        return calculate(Input.of(this.input).splitByString());
    }
}
