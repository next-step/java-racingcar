package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
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
        return -1; // Enum에서 Exception으로 처리해주고 싶은데 어떡하면 좋을까?
    }

}
