

import java.util.Scanner;

import static com.sun.tools.internal.xjc.reader.Ring.add;

public class StringCalculator {

    // 각 연산의 결과값을 저장하는 변수
    public static int addResult, subtractResult, multiplyResult, divideResult;

    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("사칙연산을 위한 문자열을 입력해하세요");

        //사용자에게 문자열 입력
        String input = sc.nextLine();

        // 각 연산 실행
//        Add(input);
//        Subtract(input);
//        Multiply(input);
        Divide(input);

        System.out.println("더하기 결과는 " + addResult);
        System.out.println("빼기 결과는 " + subtractResult);
        System.out.println("곱하기 결과는 " + multiplyResult);
        System.out.println("나누기 결과는 " + divideResult);
    }


    /*
    add() 함수
    */

    static void Add(String input){
        int plusIndex = input.indexOf("+");
        int num1 = Character.getNumericValue(input.charAt(plusIndex-1));
        int num2 = Character.getNumericValue(input.charAt(plusIndex+1));
        addResult = num1 +num2;

    }

    /*
    Subtract() 함수
    */
    static void Subtract(String input){
        int plusIndex = input.indexOf("-");
        int num1 = Character.getNumericValue(input.charAt(plusIndex-1));
        int num2 = Character.getNumericValue(input.charAt(plusIndex+1));
        subtractResult = num1 -num2;

    }

    /*
    Multiply() 함수
    */
    static void Multiply(String input){
        int plusIndex = input.indexOf("*");
        int num1 = Character.getNumericValue(input.charAt(plusIndex-1));
        int num2 = Character.getNumericValue(input.charAt(plusIndex+1));
        multiplyResult = num1 * num2;

    }

    /*
    Divide() 함수
    */
    static void Divide(String input){
        int plusIndex = input.indexOf("/");
        int num1 = Character.getNumericValue(input.charAt(plusIndex-1));
        int num2 = Character.getNumericValue(input.charAt(plusIndex+1));
        divideResult = num1 / num2;
    }

}
