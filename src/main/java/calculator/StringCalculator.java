package calculator;

import java.util.Objects;

public class StringCalculator {

    public static int calculate(String input) {
        checkNull(input);

        String[] splitInput = input.split(" ");
        int result = Integer.parseInt(splitInput[0]);

        for (int i = 1; i < splitInput.length; i += 2) {
            result = operate(splitInput[i], result, Integer.parseInt(splitInput[i+1]));
        }

        return result;
    }

    private static void checkNull(String input) {
        boolean check = Objects.isNull(input);
        if (check) {
            throw new IllegalArgumentException("입력 값이 공백입니다.");
        }
    }

    private static int operate(String sign, int left, int right) {
        if(sign.equals("+")){
            return Operator.add(left,right);
        }
        if(sign.equals("-")){
            return Operator.subtract(left,right);
        }
        if(sign.equals("*")){
            return Operator.multiply(left,right);
        }
        if(sign.equals("/")){
            return Operator.divide(left,right);
        }
        throw new IllegalArgumentException("사칙 연산 기호가 아닙니다.");
    }

}

