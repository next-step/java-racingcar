package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    //1. 값을 입력받는다.
    //3. 값을 자르기 전에 검증한다. (숫자 Space 연산자 Space 숫자 Space 연산자 Space 패턴) <- 연산자는 Enum 또는 상수로 관리해도 좋겠다.
    //2. split을 통해 문자열을 자른다.
    //4. 값을 검증한다. ("/" 바로 뒤에 0이 오는 경우)
    //5. 값이 제대로 입력되지 않았을 경우 Exception을 도출한다.
    //6. 값이 제대로 입력되었을 경우, 앞에서 부터 계산을 수행한다.

    public static int calculate(String operator, int firstNum, int secondNum) {

        if(Operator.ADD.getValue().equals(operator)) {
            return Operator.ADD.calculate(firstNum, secondNum);
        }
        else if(Operator.SUBTRACT.getValue().equals(operator)) {
            return Operator.SUBTRACT.calculate(firstNum, secondNum);
        }
        else if(Operator.MULTIPLY.getValue().equals(operator)) {
            return Operator.MULTIPLY.calculate(firstNum, secondNum);
        }
        else if(Operator.DIVISION.getValue().equals(operator)) {
            return Operator.DIVISION.calculate(firstNum, secondNum);
        }
        return -1; //TODO
    }

}
