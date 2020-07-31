package calculator;

import java.util.Scanner;

public class CalculatorMain {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("문자열 연산을 입력해주세요.");
		String value = scanner.nextLine();
		int result = Calculator.process(value);
		System.out.println("결과 : " + result);
	}
}
