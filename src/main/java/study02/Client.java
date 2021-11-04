package study02;

import java.util.Scanner;

/**
 * .
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("계산할 공식을 입력하세요");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.printf("계산결과는 %d 입니다.", new StringCalculator(input).calculate().getNumber());
    }
}
