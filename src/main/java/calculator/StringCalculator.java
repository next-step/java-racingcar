package calculator;

import calculator.type.Operator;

public class StringCalculator {

    static int calculate(String[] expression) {

        int count = expression.length;

        int result = Integer.parseInt(expression[0]);
        int idx = 1;

        while (idx < count) {
            String operatorType = expression[idx++];
            int rightHandSideNumber = Integer.parseInt(expression[idx++]);
            Operator operator = Operator.typeOf(operatorType);

            result = operator.calculate(result, rightHandSideNumber);
        }

        return result;
    }

    //19.03.11 enum 클래스 기능추가, 불필요 method 제거

}
