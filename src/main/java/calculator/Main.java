package calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("계산할 값을 입력 하세요.");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        float result = new StringCalculator(input).calculate();

        System.out.println("-> " + result);
    }
}
