package setp2;

import java.util.Objects;
import java.util.regex.Pattern;

public class Calculator {
    final static Pattern hasArithmeticOperator = Pattern.compile("[^ \\s0-9+-/*]");
    final static Pattern hasNumeric = Pattern.compile("^[\\d]");
    final static Pattern hasOperator = Pattern.compile("^[+-/*]");
    public static String[] ofFormula(String input) {
        if (validateFormula(input)) {
            throw new IllegalArgumentException("입력 값이 잘못입력되었습니다.");
        }
        return input.split(" ");
    }

    protected static boolean validateFormula(String input) {
        return Objects.isNull(input)
            || input.trim().length() == 0
            || hasArithmeticOperator.matcher(input).find();
    }


    protected static boolean hasNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return hasNumeric.matcher(strNum).matches();
    }

    protected static boolean hasOperator(String strNum) {
        if (strNum == null) {
            return false;
        }
        return hasOperator.matcher(strNum).matches();
    }
}
