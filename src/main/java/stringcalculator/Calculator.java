package stringcalculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class Calculator {

    //  연산식으로 만들기
    public static String[] trimInputExpression(String targetExpression){
        return targetExpression.split(" ");
    }

    //  1. 계산식 공백 체크 (입력값 null)
    public static boolean inputExpressionIsNotNull(String inputExpression){
        if (inputExpression == null || inputExpression.isEmpty()){
            throw new IllegalArgumentException();
        }
        return true;
    }

    //  2.  올바른 연산자 체크 (사칙연산 기호가 아닌 경우)
    public static boolean isValidOperator(String inputExpression){
        String trimmedExpression = inputExpression.replace(" ", "").replaceAll("[0-9]", "");
        String operators = "+-*/";
        for(int i=0; i< trimmedExpression.length(); i++){
            if(!operators.contains(trimmedExpression.substring(i, i+1))){
                throw new IllegalArgumentException();
            }
        }
        return true;
    }

    //  3. 계산기
    public static double calculate(String input){
        //  input null check
        inputExpressionIsNotNull(input);
        String expressions[] = trimInputExpression(input);
        //  계산!
        double result = Integer.parseInt(expressions[0]);
        for (int i = 0; i < expressions.length - 2; i += 2) {
            result = getOperation(expressions[i + 1], result, Integer.parseInt(expressions[i + 2]));
        }
        return result;

    }

    //  4. 연산 가져오기
    public static double getOperation(String operator, double operand1, double operand2){
        return Operator.of(operator).calculate(operand1, operand2);
    }


    //  4. 연산식이 적절한지 체크
    //  이거 좀 생각해서 만들자
    public static void isValidExpression(String  input){
        inputExpressionIsNotNull(input);
        String[] split = input.split(" ");

        IntStream.range(0, split.length)
                .filter(i -> i % 2 == 0)
                .forEach(i -> System.out.println(split[i]));

        IntStream.range(0, split.length).filter(i -> i % 2 != 0).forEach(i -> System.out.println(split[i]));
    }


}
