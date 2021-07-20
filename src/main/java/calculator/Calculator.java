package calculator;

import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

class Calculator {
    private static final Pattern NORMAL_PATTERN = Pattern.compile("^[\\d]+(\\s[\\d+*\\-/])*.\\d$");

    private String operator;
    private String string;

    private int reduce;

    private Calculator(String string) {
        isValid(string);

        this.operator = "+";
        this.string = string;
        this.reduce = 0;
    }

    public static Calculator from(String string) {
        return new Calculator(string);
    }

    private void isValid(String string) {
        if(!NORMAL_PATTERN.matcher(string).find()) {
            throw new IllegalArgumentException("숫자와 사칙 연산자만 입력 가능하며, 모든 글자 사이에는 공백이 존재해야 합니다.");
        }
    }

    public int calculate() {
        String[] split = this.string.split(" ");
        for(String s : split) {
            calculate(s);
        }
        return reduce;
    }

    private void calculate(String s) {
        if(!s.matches("[+*\\-/]")) {
            this.reduce = ArithmeticCalculator.apply(operator, reduce, parseInt(s));
            return;
        }
        this.operator = s;
    }
}
