package calculator;

import java.util.ArrayList;
import java.util.List;

public class MyNumber {

    private static final String[] OPERATOR = {"+", "-", "*", "/"};
    private List<String> operands = new ArrayList<>();
    private List<String> operators = new ArrayList<>();

    public MyNumber(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }

        String[] inputs = input.split(" ");
        addOperands(inputs);
        addOperators(inputs);
    }


    private boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    private void addOperands(String[] inputs) {
        for (int i = 0; i < inputs.length; i = i + 2) {
            operands.add(inputs[i]);
        }
    }

    private void addOperators(String[] inputs) {
        for (int i = 1; i < inputs.length; i = i + 2) {
            validateOperator(inputs[i]);
            operators.add(inputs[i]);
        }
    }

    private void validateOperator(String str) {
        if (!isOperator(str)) {
            throw new IllegalArgumentException("사칙연산자가 아닙니다.");
        }
    }

    private boolean isOperator(String str) {
        for (String op : OPERATOR) {
            if (str.equals(op)) return true;
        }
        return false;
    }
}
