package racing_car;

import java.util.Arrays;

public class Validation {
    private Calculator calculator;
    private String operator[] = {"+","-","*","/"};
    public String[] nullCheck(String input){
        if (input == null || input.equals("")){
            throw new IllegalArgumentException("입력 값이 null 입니다.");
        }
        return input.split(" ");
    }
    public void split(String[] str){
        if (str.length<3){
            throw new IllegalArgumentException("입력 값이 유효하지 않습니다");
        }
    }
    public int validationCheck(String str[]){
        int first =Integer.parseInt(str[0]);
        int result = first;
        calculator = new Calculator();
        for (int i=1; i<str.length; i+=2){
            String op =str[i];
            if (!(Arrays.asList(operator).contains(op))){
                throw new IllegalArgumentException("사칙 연산 기호가 아닙니다");
            }
            int second = Integer.parseInt(str[i + 1]);
            result = calculator.operation(result, op , second);
        }
        return result;
    }
}
