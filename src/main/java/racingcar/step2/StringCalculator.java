package racingcar.step2;

import java.util.regex.Pattern;

/**
 * Created : 2020-10-29 오후 2:33
 * Developer : Seo
 */
public class StringCalculator {

    public int plus(String s1, String s2) {
        return Integer.parseInt(s1) + Integer.parseInt(s2);
    }

    public int minus(String s1, String s2) {
        return Integer.parseInt(s1) - Integer.parseInt(s2);
    }

    public int multiply(String s1, String s2) {
        return Integer.parseInt(s1) * Integer.parseInt(s2);
    }

    public int divide(String s1, String s2) {
        return Integer.parseInt(s1) / Integer.parseInt(s2);
    }

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
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 != 0) {
                isOperator(arr[i]);
            } else {
                isNumeric(arr[i]);

                if (i == 0) {
                    sum = plus(String.valueOf(sum), arr[i]);
                    continue;
                }

                switch (arr[i - 1]) {
                    case "+":
                        sum = plus(String.valueOf(sum), arr[i]);
                        break;
                    case "-":
                        sum = minus(String.valueOf(sum), arr[i]);
                        break;
                    case "*":
                        sum = multiply(String.valueOf(sum), arr[i]);
                        break;
                    case "/":
                        sum = divide(String.valueOf(sum), arr[i]);
                        break;
                    default:
                        break;
                }
            }
        }
        return sum;
    }


}
