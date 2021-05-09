package calculaor;

import java.util.HashMap;
import java.util.Map;

public class Evaluation {
    // 문자형을 숫자형으로 변환
    public int convertToNumber(String input) {
        return Integer.parseInt(input);
    }

    // 사칙연산 부호 평가하기
    public int operatorEvaluation(int firstNum, String operatorValue, int secondNum) {
        Operator operator = new Operator();
        Map operatorList = new HashMap<String, Integer>();
        int operatorResult;

        operatorList.put("+", operator.add(firstNum, secondNum));
        operatorList.put("-", operator.sub(firstNum, secondNum));
        operatorList.put("*", operator.mul(firstNum, secondNum));
        operatorList.put("/", operator.div(firstNum, secondNum));

        operatorResult = (int) operatorList.get(operatorValue);

        return operatorResult;
    }

    // 사칙연산 부호 예외처리 ex) $ # ^
    public int operatorException(int firstNum, String operatorValue, int secondNum) {
        try {
            return operatorEvaluation(firstNum, operatorValue, secondNum);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("연산기호가 아닙니다.");
        }
    }
}
