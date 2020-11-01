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

    // 계산
    double calculate() {
        double firstNumber = numberList.poll();

        return numberList.stream().reduce(firstNumber, (a, b) -> OperateType.operate(operatorList.poll(), a, b));
    }
}
