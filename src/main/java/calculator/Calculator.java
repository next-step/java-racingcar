package calculator;

import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

class Calculator {
    private static final Pattern NORMAL_PATTERN = Pattern.compile("^[\\d]+(\\s[\\d+*\\-/])*.\\d$");
    private static final Pattern OPERATOR_PATTERN = Pattern.compile("[+*\\-/]");

    private String operator;
    private String string;

    private int reduce;

    private Calculator(String string) {
        verify(string);

        this.operator = "+";
        this.string = string;
        this.reduce = 0;
    }

    public static Calculator from(String string) {
        return new Calculator(string);
    }

    private void verify(String string) {
        if(!isPatternMatch(NORMAL_PATTERN, string)) {
            throw new IllegalArgumentException("숫자와 사칙 연산자만 입력 가능하며, 모든 글자 사이에는 공백이 존재해야 합니다.");
        }
    }

    private boolean isPatternMatch(Pattern pattern, String source) {
        return pattern.matcher(source).find();
    }

    public int calculate() {
        String[] split = this.string.split(" ");
        for(String s : split) {
            calculate(s);
        }
        return reduce;
    }

    private void calculate(String s) {
        if(!isPatternMatch(OPERATOR_PATTERN, s)) {
            this.reduce = ArithmeticCalculator.apply(operator, reduce, parseInt(s));
            return;
        }
        this.operator = s;
    }
}
