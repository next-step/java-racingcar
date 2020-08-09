package stringcalculator.util;

import stringcalculator.Constants;
import stringcalculator.StringCalOperator;

public class StringCalculator {
    // 입력 문자열의 '숫자' 와 '사칙연산' 사이 반드시, 빈 공백 문자열, final 변수 지정

    //인스턴스화 방지 위한 private 생성자 선언 (08.02)
    private StringCalculator(){
        throw new IllegalArgumentException(Constants.PROTECTED_UTIL_CLASS);
    }

    public static int calculate(String expression){
        if (isBlank(expression)) {
            throw new IllegalArgumentException(Constants.INPUT_VALUE_IS_EMPTY);
        }
        return applyStrOperator(expression);
    }

    /**
     * 기존 applyStrOperator refactor 실패원인 : expression과 expression[i] 인자 불일치
     * javajigi님 tip : 인자를 단일 (String expression)으로 복수의 쪼개진 expression에 대해
     * String[] expressions = expression.split(" "); 로 정의
     */
    public static int reCalculate(String expression) {
        String[] expressions = expression.split("");
        int first = toInt(0, expressions);
        int second = toInt(2, expressions);
        String operator = expressions[1];
        return first + second;
    }

    private static int toInt(int i, String[] expressions) {
        return Integer.parseInt(expressions[i]);
    }

    private static int applyStrOperator(String expression) {
        int number = toInt(0, splitBySpace(expression));
        for (int i = 1; i < splitBySpace(expression).length; i = i + 2) {
            StringCalOperator strOperation = StringCalOperator.findOperation(splitBySpace(expression)[i]);
            number = strOperation.applyAsInt(number, toInt(i + 1, splitBySpace(expression)));
        }
        return number;
    }

    private static boolean isBlank(String expression){
        return expression == null || expression.isEmpty();
    }

    private static String[] splitBySpace(String expression){
        return expression.split(" ");
    }

}

//******** SPLIT DELIMITER(String 취소) & REGEX 학습 필요 *************//
//******** 심화 : Colletion API 활용하여 숫자, 연산자 관리  *************//
//******** 심화 : Scanner.input 통해 parseInt 및 반복문 적용 *************//

