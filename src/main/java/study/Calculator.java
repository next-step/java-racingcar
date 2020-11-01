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
        // 2. 잘못된 연산자 체크
        checkOperator();
        // 3. 숫자, 연산자 세팅
        setNumberAndOperatorList();
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

    // 연산자 체크
    private void checkOperator() {
        // 숫자랑, 사칙연산 제외 값이 있는지 확인
        String inputRemoveWhitespace = removeWhitespace(input);
        String notOperators = inputRemoveWhitespace.replaceAll("[0-9]|[+]|[-]|[*]|[/]", "");
        if (notOperators.length() > 0) {
            throw new IllegalArgumentException("IllegalArgumentException");
        }
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

    // 계산
    double calculate() {
        double firstNumber = numberList.poll();

        return numberList.stream().reduce(firstNumber, (a, b) -> OperateType.operate(operatorList.poll(), a, b));
    }
}
