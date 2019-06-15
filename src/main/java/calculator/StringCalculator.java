package calculator;

import org.apache.commons.lang3.StringUtils;

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

        if(StringUtils.equals(Math.ADDITION.getSign(),strings[1]))
            return addition(number1, number2);


        if(StringUtils.equals(Math.SUBTRACTION.getSign(),strings[1]))
            return substraction(number1, number2);

        return 0;
    }

    public int calculate() {
        return calculate(Splitter.of(this.input).splitByString());
    }
}
