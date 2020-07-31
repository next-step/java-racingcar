package calculator;

import java.util.Scanner;

import calculator.executor.Calculator;

public class CalculatorApplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Calculator calculator = new Calculator();

		System.out.println("계산할 내용을 입력하세요.");

		String userInput = scanner.nextLine();
		int result = calculator.execute(userInput);

		System.out.println(String.format("결과는 %s입니다.", result));

	}
}
