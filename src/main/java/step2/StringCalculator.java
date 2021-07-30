package step2;

import java.util.regex.Pattern;

public class StringCalculator {
    private static final Pattern pattern = Pattern.compile("^[0-9]*$");

    public static int calculate(Formulas input) {
        String[] formulas = input.getFormulas();
        int result = toInt(formulas[0]);
        for (int i = 1; i < formulas.length; i += 2) {
            result = OperatorType.operate(result, toInt(formulas[i + 1]), formulas[i]);
        }
        return result;
    }

    private static int toInt(String formula) {
        if (pattern.matcher(formula).find()) {
            return Integer.parseInt(formula);
        }
        throw new IllegalArgumentException("숫자가 아닌 값을 숫자로 변형할 수 없습니다.");
    }
}
