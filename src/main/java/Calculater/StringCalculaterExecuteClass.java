package Calculater;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StringCalculaterExecuteClass {
    private static final Map<String, Calculator> stringCalculater = new HashMap<>();
    private static final Map<String, Calculator> unmodifyableStringCalculater = Collections.unmodifiableMap(stringCalculater);



    static{
        stringCalculater.put("+", new Plus());
        stringCalculater.put("-", new Subtract());
        stringCalculater.put("*", new Multiply());
        stringCalculater.put("/", new Division());
    }

    private static int result(String operator, int number1, int number2){
        Calculator calculator = unmodifyableStringCalculater.get(operator);
        return calculator.resultCalculater(number1, number2);
    }

    public int stringCalculator(String[] numberAndOperator){
        int result =0;

        for(int i=0 ; i<=numberAndOperator.length/2 + 2; i+=2){
            if(result == 0){
                result = this.result(numberAndOperator[i+1] , Integer.parseInt(numberAndOperator[i]), Integer.parseInt(numberAndOperator[i+2]));
            }else{
                result = this.result(numberAndOperator[i+1] , result, Integer.parseInt(numberAndOperator[i+2]));
            }
        }
        return result;
    }
}
