package step2.calculator.ui;

import java.util.Scanner;

import step2.calculator.domain.Calculator;

public class CalculatorView {

	public static String readInput() {
		final Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	public void run() {
		final Calculator calculator = new Calculator();
		try {
			System.out.println(calculator.calculate(readInput()));
		} catch (Exception e) {
			System.out.printf("오류 발생: %s", e.getMessage());
		}
	}
}
