package step2;

public class Calculator {

    public static int calculate(String text) {
        Validation.validNullAndEmpty(text);
        final String[] values = text.split(" ");

        MyNumber first = new MyNumber(values[0]);
        for (int i = 1; i < values.length - 1; i += 2) {
            String operator = values[i];
            MyNumber second = new MyNumber(values[i + 1]);
            first = calculate(first, operator, second);
        }
        return first.getNumber();
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
        throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
    }

}
