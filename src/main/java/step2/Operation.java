package step2;

public class Operation {

    private Operation(){
    }

    private static final String SEPARATOR = " ";

    public static int calculate(String expression) {

        String[] ops = expression.split(SEPARATOR);

        int operand = convert(ops[0]);
        String operator;
        for (int i = 1; i < ops.length; i += 2) {
            operator = ops[i];
            operand = getValue(operator, operand, convert(ops[i+1]));

        }
        return operand;
    }

    private static int convert(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Input number is null or empty");
        }
        return Integer.parseInt(s);
    }

    private static int getValue(String operator, int a, int b) {
        return StringOperator.of(operator).calculate(a, b);
    }

}
