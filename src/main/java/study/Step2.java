package study;

import study.stringCalculator.StringCalculator;

public class Step2 {

    public static int calculateString(String input_string) {
        return new StringCalculator().calculate(input_string);
    }
}
