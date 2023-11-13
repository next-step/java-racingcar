package study;

import study.calculator.StringCalculator;

public class Step2 {

    public static int calculateString(String input_string) {
        return new StringCalculator().calculate(input_string);
    }
}
