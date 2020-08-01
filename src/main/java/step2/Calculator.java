package step2;

import java.util.Objects;
import java.util.regex.Pattern;

import static step2.Operator.calculate;

public class Calculator {
    private final String[] formula;
    final static Pattern hasArithmeticOperator = Pattern.compile("[^ \\s0-9+-/*]");

    public Calculator(String input) {
        this.formula = ofFormula(input);
    }

    protected static String[] ofFormula(String input) {
        if (validateFormula(input)) {
            throw new IllegalArgumentException("입력 값이 잘못입력되었습니다.");
        }
        return input.split(" ");
    }

    public int getOperationResult() {
        int result = Integer.parseInt(formula[0]);
        int i = 0;
        while (i < formula.length - 2) {
            result = calculate(result, formula[i + 1], Integer.parseInt(formula[i + 2])).intValue();
            i += 2;
        }
        return result;
    }

    protected static boolean validateFormula(String input) {
        return Objects.isNull(input)
            || input.trim().length() == 0
            || hasArithmeticOperator.matcher(input).find();
    }
}
