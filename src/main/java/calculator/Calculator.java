package calculator;

import static calculator.NumberUtils.isNumeric;

public class Calculator {

    public static void main(String[] args) {
        new Calculator().run();
    }

    private void run() {
        String input = "2 + 3 * 4 / 2";

        long result = calculate(input);
        System.out.println(result);
    }

    public long calculate(String inputString) {

        CalculatorItemCollection collection = new CalculatorItemCollection(inputString);

        long result = 0;
        OperatorType operatorType = null;

        for (String s : collection.getItem()) {

            if (isNumeric(s)) {
                long number = Long.parseLong(s);
                result = operatorType == null ? number : operatorType.getExpression().apply(result, number);
                continue;
            }
            operatorType = OperatorType.findByCode(s);
        }

        return result;
    }

}
