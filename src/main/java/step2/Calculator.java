package step2;

public class Calculator {

    public static int calculate(String text) {
        final String[] values = text.split(" ");

        MyNumber first = new MyNumber(values[0]);
        MyNumber second = new MyNumber(values[2]);
        String operator = values[1];

        return calculate(first, operator, second).getNumber();
    }

    private static MyNumber calculate(MyNumber first, String operator, MyNumber second) {
        if (operator.equals("+")) {
            return first.plus(second);
        }
        if (operator.equals("-")) {
            return first.minus(second);
        }
        if (operator.equals("*")) {
            return first.multiple(second);
        }
        if (operator.equals("/")) {
            return first.divide(second);
        }
        return null;
    }
}
