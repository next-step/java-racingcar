package calculator;

import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args) {
        System.out.println("계산 할 문자열을 입력하세요.");
        Scanner sc = new Scanner(System.in);
        String formula = sc.nextLine();
        int result = Calculator.calculate(formula);
        System.out.println("계산결과 : " + result);
    }
}
