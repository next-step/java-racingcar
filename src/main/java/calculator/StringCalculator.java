package calculator;

import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class StringCalculator {

	public static void run() {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();

		System.out.println(stringCalculate(input));
	}

	public static int stringCalculate(String input) {
		if (StringUtils.isEmpty(input)) {
			throw new IllegalArgumentException();
		}

		String[] components = input.split(" ");

		int calculateResult = toInteger(components[0]);
		for(int i = 1; i < components.length ; i = i + 2) {
			calculateResult = Calculator.calculate(calculateResult, components[i], toInteger(components[i + 1]));
		}
		return calculateResult;
	}

	private static int toInteger(String number) {
		if (StringUtils.isEmpty(number)) {
			throw new IllegalArgumentException();
		}
		return Integer.parseInt(number);
	}
}
