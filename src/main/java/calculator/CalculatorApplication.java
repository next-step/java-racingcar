package calculator;

import java.util.Scanner;

public class CalculatorApplication {
    public static void main(String[] args) {
        System.out.println("계산 할 문자열을 입력하세요.");
        Scanner sc = new Scanner(System.in);
        String inputValue = sc.nextLine();
        Calculator calculator = new Calculator();
        int result = calculator.calculate(inputValue);
        System.out.println("계산결과 : " + result);
    }
}
