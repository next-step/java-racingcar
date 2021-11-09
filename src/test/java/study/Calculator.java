package study;

public class Calculator {

    public static int calculate(String s) {
        String[] values = s.split(" ");
        InputNumber first = new InputNumber(values[0]);
        InputNumber second = new InputNumber(values[2]);
        String operator = values[1];

        return calculate(first, second, operator).getInputNumber();
    }

    public static InputNumber calculate(InputNumber first, InputNumber second, String operator) {
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
