package calculator;

public class StringCalculator {

    public int calculate(String text) {
        String[] input = text.split("");

        int result = Integer.parseInt(input[0]);
        for (int i = 0; i < input.length - 2; i = i + 2) {
            result = calculate(result, input[i + 1], Integer.parseInt(input[i + 2]));
        }

        return result;
    }

    private int calculate(int left, String symbol, int right) {
        Operator operator = Operator.find(symbol);
        return operator.calculate(left, right);
    }

}
