package calculator;

import calculator.operator.*;
import calculator.utils.StringUtil;

public class Calculator {
    static public String getValidExpr(String in) throws IllegalArgumentException{
        if(in == null || in.isEmpty() || in.replace(" ","").length() == 0){
            throw new IllegalArgumentException("입력된 값에 오류가 있습니다.");
        }
        return in;
    }

    static public Operator getOperator(String in) throws IllegalArgumentException{
        if(in.equals("+")){
            return new Addition();
        }

        if(in.equals("-")){
            return new Subtraction();
        }

        if(in.equals("*")){
            return new Multiplication();
        }

        if(in.equals("/")){
            return new Division();
        }

        throw new IllegalArgumentException("사칙연산 기호가 아닌 값이 들어왔습니다.");

    }

    static public long getResult(String expr){
        String[] items = StringUtil.split(expr, " ");

        Long acc = Long.valueOf(items[0]);
        for(int i =1; i<items.length; i = i+2){
            acc = Calculator.getOperator(items[i]).action(acc, Long.valueOf(items[i+1]));
        }

        return acc;
    }

}
