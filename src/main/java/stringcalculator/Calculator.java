package stringcalculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Calculator {

    //  연산식으로 만들기
    public String trimInputExpression(String targetExpression){
        return targetExpression.replace(" ", "");
    }

    //  1. 계산식 공백 체크
    private static void inputExpressionIsNull(String inputExpression){
        if (inputExpression == null || inputExpression.isEmpty()){
            throw new IllegalArgumentException();
        }
    }

    //  2.  올바른 연산자 체크
    public boolean isValidOperator(String inputExpression){
        String trimmedExpression = inputExpression.replace(" ", "").replaceAll("[0-9]", "");
        String operators = "+-*/";
        for(int i=0; i< trimmedExpression.length(); i++){
            if(!operators.contains(trimmedExpression.substring(i, i+1))){
                throw new IllegalArgumentException();
            }
        }
        return true;
    }

}
