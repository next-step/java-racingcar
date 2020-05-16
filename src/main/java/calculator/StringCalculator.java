package calculator;

public class StringCalculator {

    public static int calculate(String formula) {
        String[] splitFormula = SplitUtils.split(formula);

        int result = Integer.parseInt(splitFormula[0]);
        for (int i = 1 ; i < splitFormula.length ; i+=2) {
            result = FourOperation.valueOfOperator(splitFormula[i]).apply(result, Integer.parseInt(splitFormula[i + 1]));
        }

        return result;
    }
}
