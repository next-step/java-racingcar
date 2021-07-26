package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.BiFunction;
import java.util.function.Function;

public class StringCalculator {

    static int answer = 0;

    public enum Operator {
        ADD("+", (inputElement, postElement) -> inputElement + postElement),
        SUBTRACT("-", (inputElement, postElement) -> inputElement - postElement),
        MULTIPLY("*", (inputElement, postElement) -> inputElement * postElement),
        DIVIDE("/", (inputElement, postElement) -> inputElement / postElement);

        private final String operator;
        private BiFunction<Integer, Integer, Integer> expression;

        private Operator(String operator, BiFunction<Integer, Integer, Integer> expression) {
            this.operator = operator;
            this.expression = expression;
        }

        public String getOperator() {
            return operator;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(calculate(input));
    }

    public static int calculate(String input) {

        if (input == null || input.trim().isEmpty())
            throw new IllegalArgumentException();

        String[] inputArray = input.split(" ");

        for (int i = 0; i < inputArray.length; i++) {

            if (i == inputArray.length - 1)
                break;

            String inputElement = inputArray[i];
            String postElement = inputArray[i + 1];

            if (i == 0) {
                answer = toInt(inputElement);
                continue;
            }

            if (inputElement.equals(Operator.ADD.getOperator())) {
                add(postElement);
            }
            if (inputElement.equals(Operator.SUBTRACT.getOperator())) {
                subtract(postElement);
            }
            if (inputElement.equals(Operator.MULTIPLY.getOperator())) {
                multiply(postElement);
            }
            if (inputElement.equals(Operator.DIVIDE.getOperator())) {
                divide(postElement);
            }
            throw new IllegalArgumentException(); //숫자나 사칙연산 이외의 입력값 예외처리
        }
        return answer;
    }

    public static int toInt(String inputElement) {
        return Integer.parseInt(inputElement);
    }

    public static int add(String postElement) {
        return answer += toInt(postElement);
    }

    public static int subtract(String postElement) {
        return answer -= toInt(postElement);
    }

    public static int multiply(String postElement) {
        return answer *= toInt(postElement);
    }

    public static int divide(String postElement) {
        return answer /= toInt(postElement);
    }
}
