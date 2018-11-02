package calculator;

public class StringCalculator {

    private CalculatorFactory factory = null;

    public StringCalculator(CalculatorFactory factory) {
        this.factory = factory;
    }

    public int calculator(String text) {
        String[] values = text.split(" ");

        int sum = Integer.parseInt(values[0]);
        String operator = null;

        for (int i = 1; i < values.length; i+=2) {
            // 연산자 추출
            operator = values[i];

            sum = calculator(operator, sum, Integer.parseInt(values[i+1]));
        }

        return sum;
    }

    private int calculator(String operator, int a, int b) {
        Calculator calculator = factory.create(operator);
        return calculator.calc(a, b);
    }
}
