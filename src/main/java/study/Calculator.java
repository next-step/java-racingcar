package study;

import java.util.ArrayList;

public class Calculator {
    private String input;
    private ArrayList<Double> numberList = new ArrayList<>();
    private ArrayList<String> operatorList = new ArrayList<>();

    public Calculator() {

    }

    public Calculator(String input) {
        this.input = input;

        // 1. 공백체크
        checkIsBlank();
        // 2. 숫자, 연산자 세팅
        setNumberAndOperatorList();
        // 3. 잘못된 연산자 체크
        checkOperator();
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

    // 숫자, 문자 구분
    private void setNumberAndOperatorList() {
        String[] arrInputSplit = input.split(" ");
        for (String inputSplit : arrInputSplit) {
            try {
                Double parseDouble = Double.parseDouble(inputSplit);
                numberList.add(parseDouble);
            } catch (NumberFormatException e) {
                operatorList.add(inputSplit);
            }
        }
    }

    // 기호체크
    private void checkOperator() {
        // 기호가 하나이상 입력되어있거나, 사칙연산이 아닌경우
        for (String operator : operatorList) {
            if (operator.toCharArray().length > 1
                    || !"+-*/".contains(operator)) {
                throw new IllegalArgumentException("IllegalArgumentException");
            }
        }
    }

    // 계산
    double calculate() {
        double firstNumber = getFirstNumber();
        return numberList.stream().reduce(firstNumber, (a, b) -> operate(a, b));
    }

    private Double getFirstNumber() {
        double firstNumber = numberList.get(0);
        numberList.remove(0);
        return firstNumber;
    }

    // 연산
    private double operate(double a, double b) {
        double result = 0;

        String operator = getOperator();

        switch(operator) {
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
        String operator = operatorList.get(0);
        operatorList.remove(0);
        return operator;
    }
}
