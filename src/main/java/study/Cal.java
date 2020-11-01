package study;

import java.util.ArrayList;
import java.util.List;

public class Cal {

    //연산할 숫자 저장
    List<Integer> number = new ArrayList<Integer>();
    //연산자 저장
    List<String> operator = new ArrayList<String>();

    //덧셈
    public int add(int firstNum, int secondNum){
        return firstNum + secondNum;
    }

    //뺄셈
    public int sub(int firstNum, int secondNum){
        return firstNum - secondNum;
    }

    //곱셈
    public int mul(int firstNum, int secondNum){
        return firstNum * secondNum;
    }

    //나눗셈
    public int div(int firstNum, int secondNum){
        return firstNum / secondNum;
    }

    //입력값 확인
    void checkInput(String input){
        if(input == null || input ==""){
            throw new IllegalArgumentException("It's empty");
        }
    }

    //입력값 중에 숫자가 맞는지 판별
    boolean checkNumber(String input){
        boolean isNum = true;
        for(int i=0;i<input.length();i++){
            if(!Character.isDigit(input.charAt(i))){
                return false;
            }
        }
        return isNum;
    }

    //숫자와 연산자 리스트를 따로 저장하기 위한 작업
    void init(String input){
        checkInput(input);

        String[] splitedStr = input.split(" ");

        for(int i=0;i<splitedStr.length;i++){
            if(checkNumber(splitedStr[i])){
                number.add(Integer.parseInt(splitedStr[i]));
            }else{
                operator.add(splitedStr[i]);
            }
        }
    }


    //사칙연산 진행
    int calculate(String input){
        init(input);
        int result = 0;
        int first, second = 0;
        for(int i=0;i<operator.size();i++){
            if(i == 0){
                first = number.remove(0);
            }else{
                first = result;
            }

            second = number.remove(0);
            switch (operator.get(i)){
                case "+":
                    result = add(first, second);
                    break;
                case "-":
                    result = sub(first, second);
                    break;
                case "*":
                    result = mul(first, second);
                    break;
                case "/":
                    result = div(first, second);
                    break;
                default:
                    throw new IllegalArgumentException("It's not operator");
            }
        }
        return result;
    }
}
