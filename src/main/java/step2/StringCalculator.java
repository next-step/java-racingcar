package step2;

import java.util.regex.Pattern;

public class StringCalculator {
    private static final Pattern pattern = Pattern.compile("^[0-9]*$");

    public static int calculate(Formulas input) {
        String[] formulas = input.getFormulas();
        int result = getInt(formulas[0]);
        for (int i = 1; i < formulas.length; i += 2) {
            OperatorType operatorType = OperatorType.find(formulas[i]);
            result = operatorType.operate(result, getInt(formulas[i + 1]));
        }
        return result;
    }

    private static int getInt(String formula) {
        if (pattern.matcher(formula).find()) {
            return Integer.parseInt(formula);
        }
        throw new IllegalArgumentException();
    }
}
