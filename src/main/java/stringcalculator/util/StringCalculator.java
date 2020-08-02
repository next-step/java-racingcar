package stringcalculator.util;

import stringcalculator.Constants;
import stringcalculator.StringCalOperator;

public class StringCalculator {
    // 입력 문자열의 '숫자' 와 '사칙연산' 사이 반드시, 빈 공백 문자열, final 변수 지정
    //******** SPLIT DELIMITER(String 취소) & REGEX 학습 필요 *************//

    //Singleton 생성자 유지 : 정적 메소드만 사용하는 유틸리티 클래스로 해결(08.02)
    //******** null값 에러, 인스턴스화 방지 로직 구별 필요 *************//

    public static String EXPRESSION;
    //InstantiationException : junit Test 불가
    private StringCalculator(){
        throw new IllegalArgumentException(Constants.PROTECTED_UTIL_CLASS);
    }


    public StringCalculator(String EXPRESSION) {
        if (EXPRESSION == null || EXPRESSION .isEmpty()) {
            throw new IllegalArgumentException(Constants.INPUT_VALUE_IS_EMPTY);
        }
        this.EXPRESSION = EXPRESSION;
    }

    //******** 심화 : Colletion API 활용하여 숫자, 연산자 관리  *************//
    //******** 심화 : Scanner.input 통해 parseInt 및 반복문 적용 *************//
    public int calculate(){
        String[] splitExpression = EXPRESSION.split(" ");
        int number = Integer.parseInt(splitExpression[0]);
        // num, op, num -> for 구문 (i = i+2), 이후 number은 parseInt(i+1)
        for (int i = 1; i < splitExpression.length; i = i + 2) {
            StringCalOperator strOperation = StringCalOperator.findOperation(splitExpression[i]);
            number = strOperation.applyAsInt(number, Integer.parseInt(splitExpression[i + 1]));
        }
        return number;
    }

}


