package calulator;

public class StringCaluculator {

    public int calculate(String s) {
        String[] input = s.split("");

        int result = Integer.parseInt(input[0]);
        for (int i = 0; i < input.length - 2; i = i + 2) {
            result = calculate(result, input[i + 1], Integer.parseInt(input[i + 2]));
        }

        return result;
    }

    private int calculate(int a, String symbol, int b) {
        Operator operator = Operator.find(symbol);
        return operator.calculate(a, b);
    }

}
