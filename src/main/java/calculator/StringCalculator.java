package calculator;

import java.util.Scanner;

public class StringCalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String inputString = scanner.nextLine();

		System.out.println(calculate(inputString));
	}

	public static int calculate(String inputString) {
		String[] components = inputString.split(" ");

		if (components.length < 3) {
			throw new IllegalArgumentException();
		}

		Calculator calculator = new Calculator(components[0], components[1], components[2]);
		int calculateResult = calculator.calculate();
		for(int i = 3; i < components.length ; i = i + 2) {
			calculator.setCalculator(calculateResult, components[i], components[i + 1]);
			calculateResult = calculator.calculate();
		}
		return calculateResult;
	}
}
