package calculator;

import errors.EmptyArgumentException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
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

    public static void main(String[] args) throws IOException, EmptyArgumentException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(calculate(input));
    }

    public static int calculate(String input) throws EmptyArgumentException {

        if (Objects.isNull(input) || input.trim().isEmpty())
            throw new EmptyArgumentException("계산식을 입력해주세요.");

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

            for (Operator o : Operator.values()) {
                if (inputElement.trim().equals(o.getOperator()))
                    o.expression.apply(answer, toInt(postElement));
            }
            throw new InvalidInputException("올바른 연산자를 입력해주세요."); //숫자나 사칙연산 이외의 입력값 예외처리
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
