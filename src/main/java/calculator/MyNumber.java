package calculator;

import java.util.ArrayList;
import java.util.List;

public class MyNumber {

    private static final String[] OPERATOR = {"+", "-", "*", "/"};
    private List<String> operands = new ArrayList<>();
    private List<String> operators = new ArrayList<>();

    public MyNumber(String input) {
        if (input == null || input.length() == 0) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }

        String[] inputs = input.split(" ");
        for (int i = 0; i < inputs.length; i++) {
            if (i % 2 == 0) {
                operands.add(inputs[i]);
            } else {
                if (!isOperator(inputs[i])) {
                    throw new IllegalArgumentException("사칙연산자가 아닙니다.");
                }
                operators.add(inputs[i]);
            }
        }
    }

    private boolean isOperator(String str) {
        for (String op : OPERATOR) {
            if (str.equals(op)) return true;
        }
        return false;
    }
}
