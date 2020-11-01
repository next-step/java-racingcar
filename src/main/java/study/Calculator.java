package study;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    private String input;
    private Queue<Double> numberList = new LinkedList<>();
    private Queue<String> operatorList = new LinkedList<>();

    public Calculator(String input) {
        this.input = input;

        // 1. 공백체크
        checkIsBlank();
        // 2. 숫자, 연산자 세팅
        setNumberAndOperatorList();
        // 3. 잘못된 연산자 체크
        checkOperatorList();
    }

    double sum(double a, double b) {
        return a + b;
    }

    double subtract(double a, double b) {
        return a - b;
    }

    double multiply(double a, double b) {
        return a * b;
    }

    double divide(double a, double b) {
        if (b <= 0) {
            throw new ArithmeticException("ArithmeticException");
        }
        return a / b;
    }

    // null, 빈 공백 체크
    // 입력이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
    private void checkIsBlank() {
        if (input == null || removeWhitespace(input).isEmpty()) {
            throw new IllegalArgumentException("IllegalArgumentException");
        }
    }

    // 공백제거
    private String removeWhitespace(String string) {
        return string.replaceAll(" ", "");
    }

    // 숫자, 문자 구분 반복
    private void setNumberAndOperatorList() {
        String[] arrInputSplit = input.split(" ");
        for (String inputSplit : arrInputSplit) {
            setNumberAndOperator(inputSplit);
        }
    }

    // 숫자, 문자 구분
    private void setNumberAndOperator(String inputSplit) {
        try {
            Double parseDouble = Double.parseDouble(inputSplit);
            numberList.offer(parseDouble);
        } catch (NumberFormatException e) {
            operatorList.offer(inputSplit);
        }
    }

    // 연산자 목록 체크
    private void checkOperatorList() {
        for (String operator : operatorList) {
            checkOperator(operator);
        }
    }

    // 연산자 체크
    private void checkOperator(String operator) {
        // 기호가 하나이상 입력되어있거나, 사칙연산이 아닌경우
        if (operator.toCharArray().length > 1
                || !"+-*/".contains(operator)) {
            throw new IllegalArgumentException("IllegalArgumentException");
        }
    }

    // 계산
    double calculate() {
        double firstNumber = getFirstNumber();
        return numberList.stream().reduce(firstNumber, (a, b) -> operate(a, b));
    }

    private Double getFirstNumber() {
        return numberList.poll();
    }

    // 연산
    private double operate(double a, double b) {
        double result = 0;

        String operator = getOperator();

        switch (operator) {
            case "+":
                result = sum(a, b);
                break;
            case "-":
                result = subtract(a, b);
                break;
            case "*":
                result = multiply(a, b);
                break;
            case "/":
                result = divide(a, b);
                break;
        }
        return result;
    }

    private String getOperator() {
        return operatorList.poll();
    }
}
