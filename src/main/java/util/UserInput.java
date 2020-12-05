package util;

import java.util.Scanner;

import calculator.CalculatorService;

public class UserInput extends UserOutput {

	private static final Scanner SCANNER = new Scanner(System.in);



	public static boolean isBank(String inputStr) {

		return removeBlank(inputStr).length() <= 0;
	}

	public static boolean isNumber(String inputNumber) {

		try {
			Integer.parseInt(inputNumber);
			return true;
		} catch (NumberFormatException numberFormatException) {
			return false;
		}
	}

	public static boolean isOperator(String inputOperator) {

		return (CalculatorService.OPERATOR_PLUS.equals(inputOperator)
			|| CalculatorService.OPERATOR_MINUS.equals(inputOperator)
			|| CalculatorService.OPERATOR_MULTI.equals(inputOperator)
			|| CalculatorService.OPERATOR_MOD.equals(inputOperator));
	}

	public static boolean isOperators(String[] userInput) {

		boolean result = true;
		for (int i = 1; i < userInput.length; i += 2) {
			System.out.println("OPERATOR: " + userInput[i] + isOperator(userInput[i]));
			result &= isOperator(userInput[i]);
		}

		System.out.println("Result " + result);
		return result;
	}

	public static boolean isNumbers(String[] userInput) {

		boolean result = true;
		for (int i = 0; i < userInput.length; i += 2) {
			System.out.println("NUMBER: " + userInput[i] + isNumber(userInput[i]));
			result &= isNumber(userInput[i]);
		}

		System.out.println("Result " + result);
		return result;
	}

	private static boolean isRegulars(String[] userInputArr) {

		return userInputArr.length % 2 == 1;
	}

	public static void validCalculatorString(String userInput) {

		if (isBank(userInput)) {
			throw new IllegalArgumentException("User input is bank");
		}

		String[] userInputArr = userInputArr(userInput);

		if (!isOperators(userInputArr)) {
			throw new IllegalArgumentException("User input is not operator");
		}

		if (!isNumbers(userInputArr)) {
			throw new IllegalArgumentException("User input is not number");
		}

		if (!isRegulars(userInputArr)) {
			throw new IllegalArgumentException("User input is not correct");
		}
	}

	private static String[] userInputArr(String userInput) {

		return userInput.split(" ");
	}

	private String userSystemInput() {

		return SCANNER.nextLine();
	}

	private static String removeBlank(String inputString) {

		return inputString.replaceAll(" ", "");
	}
}
