package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static void checkPattern(String str) {
        if(!str.matches("[0-9]*\\s[+|-|*|\\/]\\s[0-9]*")) {
            throw new IllegalArgumentException("입력값의 형식이 맞지 않습니다.");
        }
    }

    public static void checkDivideZero(String operator, int secondNumber) {
        if(Operator.DIVISION.getValue().equals(operator) && secondNumber == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
    }

    public static void checkEmptyOrNullInput(String src) {
        if(src.isEmpty() || src == null) {
            throw new IllegalArgumentException("빈 값이 입력되었습니다.");
        }
    }
    //TODO: 숫자가 아닌 경우 체크

}

