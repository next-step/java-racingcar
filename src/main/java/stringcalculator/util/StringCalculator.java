package stringcalculator.util;

import stringcalculator.Constants;
import stringcalculator.StringCalOperator;

import java.util.Scanner;

public class StringCalculator {
    // 입력 문자열의 '숫자' 와 '사칙연산' 사이 반드시, 빈 공백 문자열, final 변수 지정

    //인스턴스화 방지 위한 private 생성자 선언 (08.02)
    private StringCalculator(){
        throw new IllegalArgumentException(Constants.PROTECTED_UTIL_CLASS);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please use Blank between every number & operator");
        System.out.print("You want to Calculate : ");
        String expression = scanner.nextLine();
        System.out.print("The Answer is : " + calculate(expression));
    }

    public static int calculate(String expression){
        if (isBlank(expression)) {
            throw new IllegalArgumentException(Constants.INPUT_VALUE_IS_EMPTY);
        }
        return applyStrOperator(expression);
    }

    private static int applyStrOperator(String expression) {
        int number = Integer.parseInt(splitBySpace(expression)[0]);
        for (int i = 1; i < splitBySpace(expression).length; i = i + 2) {
            StringCalOperator strOperation = StringCalOperator.findOperation(splitBySpace(expression)[i]);
            number = strOperation.applyAsInt(number, Integer.parseInt(splitBySpace(expression)[i + 1]));
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

