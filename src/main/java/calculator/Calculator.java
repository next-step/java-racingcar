package calculator;

import java.util.Scanner;

public class Calculator {


    /*
     *  @param String[] strArr String 배열
     *  입력받은 값을 사칙연산을 통해 계산한다.
     * */
    public static int calculate(String[] strArr){
        ValidationUtil.validateInput(strArr);
        int total = 0;
        total += Integer.parseInt(strArr[0]);
        for(int i = 1 ; i < strArr.length -1 ; i += 2){
            int num = Integer.parseInt(strArr[i+1]);
            Operator operatorString = Operator.converterOperator(strArr[i]);
            total = operatorString.getCalculation().apply(total, num);
        }
        return total;
    }



}
