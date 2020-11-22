package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Calculator {
    /*문자열 입력받기*/
    String[] inPutVal(String val){
        isException(val);
        return splitVal(val);
    }
    /*예외처리*/
    boolean isException(String val){
        boolean isPass = false;
        if(val=="" || val == null){
             throw new IllegalArgumentException("공백이나 null 값을 입력할 수 없습니다.");
        }else{
            isPass = true;
        }
        return isPass;
    }
    /*문자열 자르기*/
    String[] splitVal(String val){
        return val.split(" ");
    }

    /*입력 값 계산*/
    int cal(String[] val){
        int resVal = 0;

        resVal = Integer.parseInt(val[0]);

        for(int i =0; i < (val.length)-2; i+=2){

            if(val[i+1].charAt(0) == '+'){
                resVal = add(resVal , Integer.parseInt(val[i+2]));
            }
            if(val[i+1].charAt(0) == '-'){
                resVal = minus(resVal , Integer.parseInt(val[i+2]));
            }
            if(val[i+1].charAt(0) == '*'){
                resVal = product(resVal , Integer.parseInt(val[i+2]));
            }
            if(val[i+1].charAt(0) == '/'){
                resVal = divide(resVal , Integer.parseInt(val[i+2]));
            }
        }
        return resVal;
    }

    int add(int num1 , int num2){
        return num1 + num2;
    }
    int minus(int num1 , int num2){
        return num1 - num2;
    }
    int product(int num1 , int num2){
        return num1 * num2;
    }
    int divide(int num1 , int num2){
        if(num1 <=0){
            throw new IllegalArgumentException(" 제수는 0이 될 수 없습니다.");
        }
        return num1 / num2;
    }


}
