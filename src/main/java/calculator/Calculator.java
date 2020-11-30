package calculator;

public class Calculator {

    public int calculate(String input) {
        FormulaMaker formulaMaker = new FormulaMaker(input);

        String[] formula = formulaMaker.getFormula();
        int ret = Integer.parseInt(formula[0]);

        for (int i = 1; i < formula.length; i += 2) {
            String symbol = formula[i];
            int num = Integer.parseInt(formula[i + 1]);

            Operator operator = Operator.getOperator(symbol);
            ret = operator.calculate(ret, num);
        }
        return ret;
    }
}
