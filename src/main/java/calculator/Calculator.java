package calculator;

public class Calculator {

	public String[] splitNumberAndOperator(String input) {
		validateInputEmptyOrNull(input);
		String[] splitInput = input.split(" ");
		validateInputOperator(splitInput);
		return splitInput;
	}

	public void validateInputOperator(String[] splitInput) {
		int splitInputLength = splitInput.length;

		for (int i = 1; i < splitInputLength - 1; i = i + 2) {
			isOperator(splitInput[i]);
		}
	}

	private void isOperator(String operator) {
		if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
			return;
		}

		throw new IllegalArgumentException();
	}

	public void validateInputEmptyOrNull(String input) {
		if (input == null || input.isEmpty() || input.equals(" ")) {
			throw new IllegalArgumentException();
		}
	}

	public int add(int firstNumber, int secondNumber) {
		return firstNumber + secondNumber;
	}

	public int subtract(int firstNumber, int secondNumber) {
		return firstNumber - secondNumber;
	}

	public int multiply(int firstNumber, int secondNumber) {
		return firstNumber * secondNumber;
	}

	public int divide(int firstNumber, int secondNumber) {
		return firstNumber / secondNumber;
	}
}
