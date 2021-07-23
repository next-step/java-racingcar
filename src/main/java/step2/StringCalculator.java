package step2;

public class StringCalculator {
    public static int calculate(String input) {
        String[] formulas = input.split(" ");
        String operator = formulas[1];

        if("+".equals(operator)) {
            return getInt(formulas[0]) + getInt(formulas[2]);
        }
        if("-".equals(operator)) {
            return getInt(formulas[0]) - getInt(formulas[2]);
        }
        if("*".equals(operator)) {
            return getInt(formulas[0]) * getInt(formulas[2]);
        }
        if("/".equals(operator)) {
            return getInt(formulas[0]) / getInt(formulas[2]);
        }

        throw new IllegalArgumentException();

    }

    private static int getInt(String formula) {
        return Integer.parseInt(formula);
    }
}
