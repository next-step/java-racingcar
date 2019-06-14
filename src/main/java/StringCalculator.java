

import java.util.Scanner;

public class StringCalculator {

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("사칙연산을 위한 문자열을 입력해하세요");

        //사용자에게 문자열 입력
        String input = sc.nextLine();
        int addResult= add(input);

        System.out.println("더하기 결과는 " + addResult);


    }


    /*
    add() 함수 단위 테스트 구현
    해당 함수는 더하기 기능 구현.
     */
//    @ParameterizedTest
//    @ValueSource(strings = {"1+2"})
    static int add(String input){
        int plusIndex = input.indexOf("+");
        int num1 =  Character.getNumericValue(input.charAt(plusIndex-1));
        int num2 = Character.getNumericValue(input.charAt(plusIndex+1));
//        assertThat(num1 + num2).toString().contains("3");
        return num1+num2;

    }

}
