package step1;

import java.util.*;

/**
 * 연산자 별 계산을 수행하는 클래스
 */

public class Calculator {

    public double callCalculate(double num, String str, double nextNum){

        double answer = 0.00;
        if(str.equals("+")){
            answer =  sum(num, nextNum);
        }

        if(str.equals("-")){
            answer = subtraction(num, nextNum);
        }

        if(str.equals("/")){
            answer = divide(num, nextNum);
        }

        if(str.equals("*")){
            answer = multiple(num, nextNum);
        }
        return answer;
    }

    public double sum(double num, double nextNum){

        return num + nextNum;
    }

    public double subtraction(double num, double nextNum){

        return num - nextNum;
    }

    public double divide(double num, double nextNum){

        if(nextNum == 0){
            throw new ArithmeticException("0 으로 나누기는 불가합니다. [0보다 크거나 작은수]로 나누기 해주세요.");
        }
        return num / nextNum;
    }

    public double multiple(double num, double nextNum){

        return num * nextNum;
    }
}
