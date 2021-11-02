package step2;

import java.util.Scanner;

public class client {
    public static void main(String[] args) {

        System.out.println("계산하고 싶은 문자열을 입력해주세요!!!");
        Scanner scanner = new Scanner(System.in);
        String strInputData = scanner.nextLine();
        StringCalculator calculator = new StringCalculator();

        String result = calculator.execute(strInputData);

        System.out.println("문자열 계산기의 결과 값은 " + result + "입니다!!!");
    }
}
