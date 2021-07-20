package calculator.calculator;

import java.util.regex.Pattern;

public class Calculator {

    private int result;
    private String operator;
    private final StringExpression expression;
    private static final Pattern patten = Pattern.compile("^[0-9]*$");

    public Calculator(StringExpression expression) {
        this.expression = expression;
        this.result = 0;
        this.operator = "+";
    }

    public int calculate() {
        String[] splits = expression.split();
        for (String str : splits) {
            calculateSplit(str);
        }

        return result;
    }

    private void calculateSplit(String str) {
        if (patten.matcher(str).find()) {
            result = Operation.apply(operator, result, Integer.valueOf(str));
            return;
        }
        operator = str;
    }
}
