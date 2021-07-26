package calculator;

import errors.EmptyArgumentException;
import errors.InvalidInputException;

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

    public static void main(String[] args) throws IOException, EmptyArgumentException, InvalidInputException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(calculate(input));
    }

    public static int calculate(String input) throws EmptyArgumentException, InvalidInputException {
        if (Objects.isNull(input) || input.trim().isEmpty())
            throw new EmptyArgumentException("계산식을 입력해주세요.");

        return operatorLoop(processInput(input));
    }

    public static int toInt(String inputElement) {
        return Integer.parseInt(inputElement);
    }

    private static String[] processInput(String input) {
        return input.split(" ");
    }

    private static int operatorLoop(String[] inputArray) throws InvalidInputException {
        int size = inputArray.length;
        int i = 0;
        while(i < size - 1) {
            String inputElement = inputArray[i];
            String postElement = inputArray[i + 1];
            answer = processOperator(inputElement, postElement);
            i++;
        }
        throw new InvalidInputException("올바른 연산자를 입력해주세요."); //숫자나 사칙연산 이외의 입력값 예외처리
    }

    private static int processOperator(String inputElement, String postElement) {
        for (Operator o : Operator.values()) {
            operateTwoNums(inputElement, postElement, o);
        }
        return answer;
    }

    private static void operateTwoNums(String inputElement, String postElement, Operator o) {
        if (inputElement.trim().equals(o.getOperator()))
            o.expression.apply(answer, toInt(postElement));
    }
}
