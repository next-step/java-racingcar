package calculator;

public class StringCalculator {

    private CalculatorFactory factory = null;

    public StringCalculator(CalculatorFactory factory) {
        this.factory = factory;
    }

    public int calculator(String text) {
        String[] values = splitFormula(text);
        if (values.length == 0) {
            return 0;
        }
        return calculator(values);
    }

    private int calculator(String[] values) {
        String operator = null;
        int sum = getAndParseNumber(values[0]);

        for (int i = 1; i < values.length; i+=2) {
            operator = getOperator(values[i]);
            sum = calculator(operator, sum, getAndParseNumber(values[i+1]));
        }

        return sum;
    }

    private String getOperator(String value) {
        return value;
    }

    private int getAndParseNumber(String value) {
        return Integer.parseInt(value);
    }

    private String[] splitFormula(String text) {
        return text.split("\\s+");
    }

    private int calculator(String operator, int a, int b) {
        Calculator calculator = factory.create(operator);
        return calculator.calc(a, b);
    }
}
