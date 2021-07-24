package step2;

public class StringCalculator {
    public static int calculate(Formulas input) {
        String[] formulas = input.getFormulas();
        String operator = formulas[1];
        OperatorType operatorType = OperatorType.find(operator);

        return operatorType.operate(getInt(formulas[0]), getInt(formulas[2]));

    }

    private static int getInt(String formula) {
        return Integer.parseInt(formula);
    }
}
