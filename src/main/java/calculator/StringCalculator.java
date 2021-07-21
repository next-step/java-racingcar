package calculator;

import java.util.Arrays;

public class StringCalculator {
    private String[] calculateStringList;

    static private String[] operatorList = {"+", "-", "*", "/"};

    public String execute(String input) {
        if (input == null || input == "" || input == " ") {
            throw new IllegalArgumentException("입력 값이 null 이거나 빈 공백 문자 입니다.");
        }

        makeCalculatedStringList(input);

        String result = "";
        String operator = "";

        for (String currentString : calculateStringList) {
            // 결과 값에 첫번째 숫자 입력
            if ("".equals(result)) {
                result = currentString;
            }
            // 연산자 인지 체크
            if (isOperator(currentString)) {
                operator = currentString;
                continue;
            }
            //연산자 있으면 현재 문자를 결과 값에 누적으로 계산
            // 계산 후에는 연산자를 다시 빈 문자열로 할당
            if (!operator.isEmpty()) {
                result = calculate(result, currentString, operator);
                operator = "";
            }
        }

        return result;
    }

    private String calculate(String result, String currentString, String operator) {
        int num1 = Integer.parseInt(result);
        int num2 = Integer.parseInt(currentString);

        if (operator.equals("+")) {
            return add(num1, num2);
        }
        if (operator.equals("-")) {
            return sub(num1, num2);
        }
        if (operator.equals("*")) {
            ;
            return mul(num1, num2);
        }
        if (operator.equals("/")) {
            return div(num1, num2);
        }

        return "";
    }

    private boolean isOperator(String operator) {
        //Operator List 에 포함되어있어 있으면 true!
        if (Arrays.stream(operatorList).anyMatch(op -> op.equals(operator))) {
            return true;
        }
        //문자가 숫자가 아니면 exception!
        if (!operator.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("올바른 사칙연산 기호가 아닙니다.");
        }
        return false;
    }

    private void makeCalculatedStringList(String input) {
        this.calculateStringList = input.split(" ");
    }

    private String add(int a, int b) {
        return Integer.toString(a + b);
    }

    private String sub(int a, int b) {
        return Integer.toString(a - b);
    }

    private String mul(int a, int b) {
        return Integer.toString(a * b);
    }

    private String div(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("0으로 나누는 연산은 수행할 수 없습니다.");
        }
        return Integer.toString(a / b);
    }
}
