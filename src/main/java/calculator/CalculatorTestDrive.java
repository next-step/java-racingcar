package calculator;

import java.util.Scanner;

public class CalculatorTestDrive {
    public static void main(String[] args) {
        String str;
        Scanner scanner = new Scanner(System.in);
        System.out.println("문자열을 입력해주세요.");
        str = scanner.next();
        int result = StringAddCalculator.splitAndSum(str);
        System.out.println("결과값: " + result);
    }
}
