package calculator;

public class StringCalculator {

    public static int calculate(String test) {
        //TODO : 입력값이 null이거나 공백일 때 처리 필요 및 값 입력 필요

        String[] values = test.split(" ");
        int result = Integer.parseInt(values[0]);

        for (int i=1; i <= values.length -1; i+=2) {
            result = calculate(result, values[i], Integer.parseInt(values[i+1]));
        }
        return result;

    }

    private static int calculate(int first, String expression, int second) {
        if (expression.equals("+")) {
            return first + second;
        }

        if (expression.equals("-")) {
            return first - second;
        }

        if (expression.equals("*")) {
            return first * second;
        }

        if (expression.equals("/")) {
            return first / second;
        }

        return 0;
    }
}

