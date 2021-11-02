package racingcar_2step;

import java.util.Arrays;

public class CalculatorValidation {

    public static void integratedCheck(String[] input) {
        arithmeticCheck(input);
        nullOrBlankCheck(input);
    }

    public static void arithmeticCheck(String[] input) {
        Arrays.stream(input).forEach(s->{
            if (!CalculatorUtil.list.contains(s) && !Character.isDigit(s.charAt(0))) {
                throw new IllegalArgumentException();
            }
        });
    }

    public static void nullOrBlankCheck(String[] input) {
        Arrays.stream(input).forEach(s->{
            if (s == null || s.equals(" ") || s.equals("")) {
                throw new IllegalArgumentException("null, 빈칸 불가능");
            }
        });
    }

    public static void divideCheck(int left, int right) {
        if(left % right != 0) {
            throw new IllegalArgumentException("정수 나눗셈만 가능");
        }
    }

}
