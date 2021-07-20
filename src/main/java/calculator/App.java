package calculator;

import calculator.calculator.Calculator;
import calculator.calculator.StringExpression;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("사칙 연산 계산을 위한 문자열을 입력해주세요.");
        String str = scanner.nextLine();
        Calculator calculator = new Calculator(new StringExpression(str));
        System.out.println(calculator.calculate());
    }
}
