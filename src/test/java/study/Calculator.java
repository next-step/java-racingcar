package study;

public class Calculator {
    public static int calculate(String s) {
        String[] values = s.split(" ");
        int first = Integer.parseInt(values[0]);
        int second = Integer.parseInt(values[2]);
        String operator = values[1];

        Integer result = calculate(first, second, operator);

        return result;
    }

    private static int calculate(int first, int second, String operator) {
        if("+".equals(operator)) {
            return first + second;
        }
        if("-".equals(operator)) {
            return first - second;
        }
        if("*".equals(operator)) {
            return first * second;
        }
        if("/".equals(operator)) {
            return first / second;
        }
        return 0;
    }

    public static int calculate2(String s) {
        String[] values = s.split(" ");
        InputNumber first = new InputNumber(values[0]);
        InputNumber second = new InputNumber(values[2]);
        String operator = values[1];

        return calculate2(first, second, operator).getInputNumber();
    }

    public static InputNumber calculate2(InputNumber first, InputNumber second, String operator) {
        if("+".equals(operator)) {
            return first.add(second);
        }
        if("-".equals(operator)) {
            return first.subtract(second);
        }
        if("*".equals(operator)) {
            return first.multiply(second);
        }
        if("/".equals(operator)) {
            return first.divide(second);
        }

        throw new IllegalArgumentException("");
    }
}
