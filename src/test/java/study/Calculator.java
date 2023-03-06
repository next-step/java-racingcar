package study;

import java.util.Iterator;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Calculator {

    private String[] inputList ;

    public float calculator(String input) {
        if (input == null || input.isEmpty())
            throw new IllegalArgumentException("입력 값이 null 이거나 비어있습니다.");
        inputList = input.split(" ");
        float result = 0;
        String sign = "";
        for(String s: inputList) {
            int number = 0;
            try {
                number = parseInt(s);
                result = innerCalculator(number, result, sign);
            } catch (NumberFormatException e) {
                sign = s;
            }
        }
        return result;
    }

    float innerCalculator(int number, float result, String sign) {
        if (sign.equals("+"))
            return add(result, number);
        if (sign.equals("-"))
            return sub(result, number);
        if (sign.equals("/"))
            return divide(result, number);
        if (sign.equals("*"))
            return multiply(result, number);
        if (sign.equals(""))
            return number;
        throw new IllegalArgumentException("사칙연산 기호가 아닙니다");
    }

    float add(float a, float b) {
        return a+b;
    }

    float sub(float a, float b) {
        return a-b;
    }

    float multiply(float a, float b) {
        return a*b;
    }

    float divide(float a, float b) {
        float c = 0;
        if ( b!= 0 )
            c = a/b;
        return c;
    }

}