package calculator;

import calculator.type.CalculationOfEachType;
import spark.utils.StringUtils;

public class StringCalculator {

    static int calculate(String text) {

        //validation (null or empty)
        if (StringUtils.isEmpty(text)) return Integer.MIN_VALUE;

        String[] values = text.split(" ");
        int count = values.length;

        int result = Integer.parseInt(values[0]);
        int idx = 1;

        while (idx < count) {
            String expression = values[idx++];
            int rightHandSideNumber = Integer.parseInt(values[idx++]);
            result = calculrate(result, rightHandSideNumber, expression);
//            result = calculrate(CalculationOfEachType.valueOf(expression), result, rightHandSideNumber);
        }

        return result;
    }

    private static int calculrate(int leftHandSideNumber, int rightHandSideNumber, String expression) {

        //enum을 처음 써보다보니 어떻게해야할지 잘 모르겠습니다. (동욱님 블로그도 보고, 여기저기 찾아봤는데 이런 case가 없었습니다
        //연산자로 enum 생성이 안되고, ADD,SUB,MUL,DIV 랑 문자열 연산자를 어떻게 연결해야할지 모르겠습니다.
        //enum 객체가 생성되야만 그 enum의 인스턴스 변수의 값을 확인할 수 있는데,
        //이 상황에서는 인스턴스 변수 값 ( + , - , *, / ) 을 통해서 ADD,SUB..,MUL.., DIV.. 를 불러와야 하는데
        //그 방법을 모르겠습니다.
        if ("+".equals(expression)) {
            return CalculationOfEachType.ADD.calculrate(leftHandSideNumber, rightHandSideNumber);
        }

        if ("-".equals(expression)) {
            return CalculationOfEachType.SUBTRACT.calculrate(leftHandSideNumber, rightHandSideNumber);
        }

        if ("*".equals(expression)) {
            return CalculationOfEachType.MULTIPLY.calculrate(leftHandSideNumber, rightHandSideNumber);
        }

        if ("/".equals(expression)) {
            return CalculationOfEachType.DIVIDE.calculrate(leftHandSideNumber, rightHandSideNumber);
        }

        return Integer.MIN_VALUE;
    }

}
