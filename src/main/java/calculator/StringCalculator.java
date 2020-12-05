package calculator;

import java.util.Scanner;

public class StringCalculator {

	public static void run() {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();

		System.out.println(stringCalculate(input));
	}

	public static int stringCalculate(String input) {
		String[] components = input.split(" ");

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
