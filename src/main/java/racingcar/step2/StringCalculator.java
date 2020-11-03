package racingcar.step2;

import java.util.regex.Pattern;

/**
 * Created : 2020-10-29 오후 2:33
 * Developer : Seo
 */
public class StringCalculator {

    public boolean isOperator(String s) {
        if (!Pattern.matches("^([+]|[-]|[*]|[/])$", s)) {
            throw new IllegalArgumentException("연산자가 아닙니다.");
        }
        return true;
    }

    public boolean isNumeric(String s) {
        if (!Pattern.matches("^([0-9]*)$", s)) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
        return true;
    }

    public int calculate(String s) {
        String[] arr = s.split(" ");
        Operator operator = null;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 != 0) {
                isOperator(arr[i]);
            } else {
                isNumeric(arr[i]);

                if (i == 0) {
                    operator = Operator.getOperator("+");
                } else {
                    operator = Operator.getOperator(arr[i - 1]);
                }

                try {
                    sum = operator.calculate(sum, arr[i]);
                } catch (ArithmeticException e) {
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
            }
        }
        return sum;
    }

}
