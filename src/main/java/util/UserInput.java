package util;

import java.util.Scanner;

import calculator.Calculator;

public class UserInput extends UserOutput {

	private static final Scanner SCANNER = new Scanner(System.in);
	private static final Boolean INPUT_CORRECT = true;
	private static final Boolean INPUT_ERROR = false;

	// 유저 입력 수
	protected Integer userResultInput;

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

		return (Calculator.OPERATOR_PLUS.equals(inputOperator)
			|| Calculator.OPERATOR_MINUS.equals(inputOperator)
			|| Calculator.OPERATOR_MULTI.equals(inputOperator)
			|| Calculator.OPERATOR_MOD.equals(inputOperator));
	}

	private static String removeBlank(String inputString) {

		return inputString.replaceAll(" ", "");
	}
}
