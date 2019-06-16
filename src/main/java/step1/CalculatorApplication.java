package step1;

import java.util.Scanner;

public class CalculatorApplication {

    public static void main(String[] args) {

        System.out.println("연산하고 싶은 문자열을 입력하세요.");
        inputStringByUser();
        int result = operator(inputStringByUser());
        System.out.println("연산 결과 : " + result);
    }

    private static String inputStringByUser() {

        Scanner scan = new Scanner(System.in);
        String inputString = scan.nextLine();
        scan.close();
        return inputString;
    }

    private static int operator(String inputString) {

        // 공백, null 예외처리
        // 사칙연산 예외처리
        // 요소 분리
        // 연산 처리
    }

}
