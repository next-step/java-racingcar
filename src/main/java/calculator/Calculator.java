package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    static Calculator cal = new Calculator();

    public static void main(String[] args) {

        Scanner scan = new Scanner( System.in );
        String calculateString = null;
        double calculateResult = 0;

        System.out.print("수식을 입력하세요 : ");
        calculateString = scan.nextLine();

        calculateResult = cal.calculator(calculateString);

        System.out.println("\""+calculateString+"\"" +"수식 계산결과 : " + calculateResult);

    }

    public double calculator(String data) {

        // null,공백문자열 검증
        if(cal.isNullOrBlank(data)) {
            throw new IllegalArgumentException();
        }

        String[] arrData = data.split(" ");
        double result = Double.parseDouble(arrData[0]);

        for(int i=1; i<arrData.length; i+=2) {
            result = calculate(result, arrData[i], Double.parseDouble(arrData[i+1]));
        }

        return result;
    }

    private double calculate(double num1, String operator, double num2) {

        if("+".equals(operator)) {
            return plus(num1,num2);
        }

        if("-".equals(operator)) {
            return minus(num1,num2);
        }

        if("*".equals(operator)) {
            return multiply(num1,num2);
        }

        if("/".equals(operator)) {
            return divide(num1,num2);
        }

        throw new IllegalArgumentException();

    }

    private double plus(double num1, double num2) {
        return num1 + num2;
    }

    private double minus(double num1, double num2) {
        return num1 - num2;
    }

    private double multiply(double num1, double num2) {
        return num1 * num2;
    }

    private double divide(double num1, double num2) {
        return num1 / num2;
    }

    private boolean isNullOrBlank(String str) {
        boolean result = false;
        if(str==null || str.isBlank()) {
            result = true;
        }
        return result;
    }

}
