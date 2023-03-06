package calculator;

import java.util.regex.Pattern;

public class StringCalculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int devide(int a, int b) {
        if(b == 0) {
            return 0;
        }
        return a / b;
    }

    public String[] seperate(String str) {

        if(str == null || str.equals("")){
            throw new IllegalArgumentException("빈값이다 이놈!");
        }

        String[] splitStrings = str.split(" ");
        for(String splitString: splitStrings) {
            if(!Pattern.matches("^[0-9+\\-*/]*$", splitString)){
                throw new IllegalArgumentException("사칙연산기호 또는 숫자가 아닙니다.");
            }
        }
        return splitStrings;
    }

    public int toInt(String str){
        return Integer.parseInt(str);
    }

    public int calculate(int a, String operator, int b){
        int tmp = 0;

        switch (operator) {
            case "+":
                tmp = add(a, b);
                break;
            case "-":
                tmp = subtract(a, b);
                break;
            case "*":
                tmp = multiply(a, b);
                break;
            case "/":
                tmp = devide(a, b);
                break;
        }

        return tmp;
    }

    public int calculator(String str) {
        String[] inputString = seperate(str);
        int result = toInt(inputString[0]);

        for(int i=0; i < inputString.length -2; i+=2) {

            result = calculate(result, inputString[i+1], toInt(inputString[i+2]));
        }

        return result;
    }

}
