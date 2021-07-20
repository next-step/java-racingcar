package racing_car;

import java.util.Arrays;

public class Calculator {
    int result;
    private String operator[] = {"+","-","*","/"};
    public int validationCheck(String str[]){
        int first =Integer.parseInt(str[0]);
        result = first;
        for (int i=1; i<str.length; i+=2){
            String op =str[i];
            if (!(Arrays.asList(operator).contains(op))){
                throw new IllegalArgumentException("사칙 연산 기호가 아닙니다");
            }
            int second = Integer.parseInt(str[i + 1]);
            result = operation(result, op , second);
        }
        return result;
    }
    public int operation(int first , String operator , int second){
        if (operator.equals("+")) result = add(first,second);
        if (operator.equals("-")) result =subtract(first,second);
        if (operator.equals("*")) result =multiply(first, second);
        if (operator.equals("/")) result =divide(first, second);

        return result;
    }

    public int add(int first, int second){
        return first+second;
    }

     public int subtract(int first, int second){
        return first-second;

    }
    public int multiply(int first , int second){
        return first*second;

    }
    public int divide(int  first, int second){
        return first/second;
    }
}
