package calculator;

import errors.EmptyArgumentException;
import errors.InvalidInputException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
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
        public BiFunction<Integer, Integer, Integer> expression;

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
        checkInputNull(input);
        answer = operatorLoop(processInput(input));
        return answer;
    }

    private static void checkInputNull(String input) throws EmptyArgumentException {
        if (Objects.isNull(input) || input.trim().isEmpty())
            throw new EmptyArgumentException("계산식을 입력해주세요.");
    }

    public static int toInt(String inputElement) {
        return Integer.parseInt(inputElement);
    }

    private static String[] processInput(String input) {
        return input.split(" ");
    }

    private static int operatorLoop(String[] inputArray) throws InvalidInputException {
        int size = inputArray.length;
        int index = 1;
        answer = toInt(inputArray[0]);
        while(index < size - 1) {
            String inputElement = inputArray[index];
            String postElement = inputArray[index + 1];
            index = compareInputToOperator(inputElement, postElement, index);
            index++;
        }
        return answer;
    }

    private static int compareInputToOperator(String inputElement, String postElement, int index) throws InvalidInputException {
        Map<String, Operator> operatorEnumMap = new HashMap<>();
        for (Operator o : Operator.values()) {
            operatorEnumMap.put(o.operator, o);
        }
        Operator inputOperator = operatorEnumMap.get(inputElement);
        if (Objects.isNull(inputOperator))
            throw new InvalidInputException("올바른 연산자를 입력해주세요."); //숫자나 사칙연산 이외의 입력값 예외처리
        answer = inputOperator.expression.apply(answer, toInt(postElement));
        return ++index;
    }
}
