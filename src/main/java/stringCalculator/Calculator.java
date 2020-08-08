package stringCalculator;


import java.util.Scanner;

public class Calculator {
/* 강의 듣기 전 작성했던 프로그램
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] stringValue = scanner.nextLine().split(" ");

        for(int i = 0; i < stringValue.length; i++){
            System.out.println(stringValue[i]);
            if(stringValue[i].isEmpty() || stringValue[i] == null || stringValue[i] == " ")
                throw new IllegalArgumentException("값이 없는 경우, null인 경우, 공백인 경우는 에러가 발생합니다");


            if(i % 2 == 1 &&  !(stringValue[i].equals("+") || stringValue[i].equals("-") ||
                                stringValue[i].equals("*") || stringValue[i].equals("/"))){
                throw new IllegalArgumentException("올바른 사칙연산 기호를 사용해주세요");
            }

        }
    }


    public int addition(int firstValue, int secondValue){
        return firstValue + secondValue;
    }

    public int subtraction(int firstValue, int secondValue){
        return firstValue - secondValue;
    }

    public int multiplication(int firstValue, int secondValue){
        return firstValue * secondValue;
    }

    public int division(int firstValue, int secondValue){
        return firstValue / secondValue;
    }

 */
}
