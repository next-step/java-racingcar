package calculator;

/**
 * Created by owen.ny on 2021/11/03.
 */
public class Calculator {
    public static MyNumber calculate(String s) {
        String[] values = s.split(" ");
        MyNumber first = new MyNumber(values[0]);
        String operator = values[1];
        MyNumber second = new MyNumber(values[2]);

        return calculate(first, operator, second);
    }

    private static MyNumber calculate(MyNumber first, String operator, MyNumber second) {
        return Operator.of(operator).calculate(first, second);
    }
}
