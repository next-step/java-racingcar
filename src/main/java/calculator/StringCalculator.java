package calculator;

import calculator.type.CalculationByOperator;

public class StringCalculator {

    static int calculate(String text) {

        String[] values = text.split(" ");
        int count = values.length;

        int result = Integer.parseInt(values[0]);
        int idx = 1;

        while (idx < count) {
            String expression = values[idx++];
            int rightHandSideNumber = Integer.parseInt(values[idx++]);
            CalculationByOperator type =  CalculationByOperator.convertTypeByOperator(expression);
            result = type.calculrate(result, rightHandSideNumber);
        }

        return result;
    }

    //19.03.11 enum 클래스 기능추가, 불필요 method 제거

}
