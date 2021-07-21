package calculator;

import static java.lang.Integer.parseInt;

import java.util.regex.Pattern;

class Calculator {
    private static final Pattern NORMAL_PATTERN = Pattern.compile("^[\\d]+(\\s[\\d+*\\-/])*.\\d$");
    private static final Pattern OPERATOR_PATTERN = Pattern.compile("[+*\\-/]");

    private final String equation;

    private String operator;
    private String data;
    private int reduce;

    private Calculator(String string) {
        verify(string);
        equation = string;
    }

    public static Calculator from(String string) {
        return new Calculator(string);
    }

    private void verify(String string) {
        if (!isPatternMatch(NORMAL_PATTERN, string)) {
            throw new IllegalArgumentException("숫자와 사칙 연산자만 입력 가능하며, 모든 글자 사이에는 공백이 존재해야 합니다.");
        }
    }

    private boolean isPatternMatch(Pattern pattern, String source) {
        return pattern.matcher(source).find();
    }

    public int calculate() {
        init();

        String[] split = this.data.split(" ");
        for (String string : split) {
            calculate(string);
        }

        return reduce;
    }

    private void init() {
        data = equation;
        operator = "+";
        reduce = 0;
    }

    private void calculate(String string) {
        if (!isPatternMatch(OPERATOR_PATTERN, string)) {
            this.reduce = ArithmeticCalculator.apply(operator, reduce, parseInt(string));
            return;
        }
        this.operator = string;
    }
}
