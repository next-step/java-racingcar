package calculator;

import java.util.regex.Pattern;

public class StrCalculator {

    public int calculator(String str) {
        String[] inputString = seperate(str);
        int result = toInt(inputString[0]);

        for(int i=0; i < inputString.length -2; i+=2) {

            result = strcalculate(result, inputString[i+1], toInt(inputString[i+2]));
        }

        return result;
    }


    //start of 사칙연산 함수 구현
    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int mul(int a, int b) {
        return a * b;
    }

    public int div(int a, int b) {
        //제수가 0일때 return 처리
        if(b == 0) {
            return 0;
        }
        return a / b;
    }
    //end of 사칙연산 함수 구현

    public String[] seperate(String str) {

        if(str == null || str.equals("")){
            throw new IllegalArgumentException("입력값 체크필요 1 : Null or 공백");
        }

        String[] splitStrings = str.split(" ");
        for(String splitString: splitStrings) {
            if(!Pattern.matches("^[0-9+\\-*/]*$", splitString)){
                throw new IllegalArgumentException("입력값 체크 필요 2 : 사칙연산, 숫자가아님");
            }
        }
        return splitStrings;
    }

    public int toInt(String str){
        return Integer.parseInt(str);
    }

    private int strcalculate(int a, String operator, int b){
        int result = 0;

        switch (operator) {
            case "+":
                result = add(a, b);
                break;
            case "-":
                result = sub(a, b);
                break;
            case "*":
                result = mul(a, b);
                break;
            case "/":
                result = div(a, b);
                break;
        }

        return result;

    }
}

