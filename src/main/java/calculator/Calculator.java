package calculator;

public class Calculator {

    // calculator version 1
    public static int calculate(String text) {
        String[] values = text.split(" ");
        int first = Integer.parseInt(values[0]);
        String operator = values[1];
        int second = Integer.parseInt(values[2]);

        return calculate(first, operator, second);
    }

    private static int calculate(int first, String operator, int second) {

        if (operator.equals("+")) {
            return first + second;
        }
        if (operator.equals("-")) {
            return first - second;
        }
        if (operator.equals("*")) {
            return first * second;
        }
        if (operator.equals("/")) {
            valid(second);
            return first / second;
        }
        return 0;
    }

    private static void valid(int second) {
        if (second == 0) {
            throw new IllegalArgumentException("분모는 0이 될 수 없습니다.");
        }
    }


    // calculator version 2
    public static MyNumber calculatorByMyNumber(String text) {
        String[] values = text.split(" ");
        MyNumber first = new MyNumber(values[0]);
        String operator = values[1];
        MyNumber second = new MyNumber(values[2]);

        return calculatorByMyNumber(first, operator, second);
    }

    private static MyNumber calculatorByMyNumber(MyNumber first, String operator, MyNumber second) {

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

        throw new IllegalArgumentException("사칙연산 기호를 확인하세요");
    }


}
