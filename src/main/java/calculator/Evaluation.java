package calculator;

import java.util.HashMap;
import java.util.Map;

public class Evaluation {
    public int convertToNumber(String input) {
        return Integer.parseInt(input);
    }

    public String convertToString(int input) {
        return Integer.toString(input);
    }

    public int checkOperator(int firstNum, String operatorValue, int secondNum) {
        Operator operator = new Operator();
        Map<String, Integer> operatorList = new HashMap<>();

        operatorList.put("+", operator.add(firstNum, secondNum));
        operatorList.put("-", operator.sub(firstNum, secondNum));
        operatorList.put("*", operator.mul(firstNum, secondNum));
        operatorList.put("/", operator.div(firstNum, secondNum));

        return operatorList.get(operatorValue);
    }

    public int isOperator(int firstNum, String operatorValue, int secondNum) {
        try {
            return checkOperator(firstNum, operatorValue, secondNum);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("연산기호가 아닙니다.");
        }
    }
}
