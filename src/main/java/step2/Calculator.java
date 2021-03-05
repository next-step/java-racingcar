package step2;

import java.util.List;

public class Calculator {
    public int calculate(String formula) {
        if (formula == null || formula.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
        return check(formula);
    }


    public int plus(int a, int b) {
        return a + b;
    }

    public int subtraction(int a, int b) {
        return a - b;
    }

    public int division(int a, int b) {
        return a / b;
    }

    public int multiplication(int a, int b) {
        return a * b;
    }

    private int check(String formula) {
        String[] token = formula.split(" ");
        int leftNumber = Integer.parseInt(token[0]);
        for (int i = 1; i < token.length; i+=2) {
            int rightNumber = Integer.parseInt(token[i+1]);
            switch (token[i]){
                case "+" :
                    leftNumber = plus(leftNumber,rightNumber);
                    break;
                case "-" :
                    leftNumber = subtraction(leftNumber,rightNumber);
                    break;
                case "*" :
                    leftNumber = multiplication(leftNumber,rightNumber);
                    break;
                case "/" :
                    leftNumber = division(leftNumber,rightNumber);
                    break;
                default :
                    throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
            }
        }
        return leftNumber;
    }
}
