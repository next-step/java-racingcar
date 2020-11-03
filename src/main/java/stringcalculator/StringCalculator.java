package stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    //분류
    //입력값이 공백이거나  null 일 경우 illegalArgumentException
    //사칙연산 기호가 아닌 경우 illegalArgumentException
    public int calculator(String value){
        String[] stringInput = value.split("");
        List<String> numbers = new ArrayList<>();
        List<String> symbol = new ArrayList<>();

        for(String str : stringInput){
            if(str.equals())
        }

        return 0;
    }

    //덧셈
    public int add(int num1, int num2){

        return 0;
    }

    //뺄셈
    public int sub(int num1, int num2){

        return 0;
    }

    //곱셈
    public int multiple(int num1, int num2){

        return 0;
    }

    //나눗셈
    public int div(int num1, int num2){

        return 0;
    }


}