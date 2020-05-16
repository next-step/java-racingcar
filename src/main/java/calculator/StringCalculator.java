package calculator;

public class StringCalculator {

    public static int calculate(String formula) {
        String[] splitFormula = SplitUtils.split(formula);

        int result = Operand.stringToInt(splitFormula[0]);
        for (int i = 1 ; i < splitFormula.length ; i+=2) {
            result = Operator.valueOfOperator(splitFormula[i]).apply(result, Operand.stringToInt(splitFormula[i + 1]));
        }

        return result;
    }
}
