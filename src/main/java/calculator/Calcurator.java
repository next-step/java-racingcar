package calculator;

import java.util.Arrays;

public class Calcurator {

    public int calcurateString(String expression) {
        String[] splitStr = expression.split(" ");
        int result=0;
        result = toInt(splitStr[0]);
        for( int i=0; i<splitStr.length -2; i+=2){
            char operator = operatorStringToChar( splitStr[i+1]);
            int secondValue = toInt(splitStr[i+2]);
            result = calcurate( result, operator, secondValue);
        }
        return result;
    }

    public char operatorStringToChar( String operator) {
        String str = operator.trim();
        isBlank( str);
        return str.charAt(0);
    }

    private int toInt( String str) {
        isBlank( str);
        return Integer.parseInt(str);
    }
    public void isBlank(String str) {
        if( str ==null || str==" "){
            throw new IllegalArgumentException("값이 존재하지 않습니다.");
        }
    }

    public int calcurate(int firstValue, char operator, int secondValue) {
        if(operator =='+') {
            return add( firstValue, secondValue);
        }
        if(operator =='-') {
            return subtract( firstValue, secondValue);
        }
        if(operator =='*') {
            return multiply( firstValue, secondValue);
        }
        if(operator =='/') {
            return divide( firstValue, secondValue);
        }
        throw new IllegalArgumentException(" 계산할 수 없는 연산자 입니다.");
    }

    public int add(int firstValue, int secondValue) {
        return firstValue + secondValue;
    }
    public int subtract(int firstValue, int secondValue) {
        return firstValue - secondValue;
    }
    public int multiply(int firstValue, int secondValue) {
        return firstValue * secondValue;
    }
    public int divide(int firstValue, int secondValue) {
        return firstValue / secondValue;
    }
}
