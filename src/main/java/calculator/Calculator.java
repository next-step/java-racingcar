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
			operatorCheck(splitInput[i]);
		}
	}

	private void operatorCheck(String operator) {
		if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
			return;
		}

		throw new IllegalArgumentException();
	}

	public void validateInputEmptyOrNull(String input) {
		if (input == null || input.trim().isEmpty()) {
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

	public int calculate(String[] splitData) {
		int sum = 0;
		int splitDataLength = splitData.length;

		sum = calculatorExecute(Integer.valueOf(splitData[0]), splitData[1], Integer.valueOf(splitData[2]));

		for (int i = 3; i < splitDataLength - 1; i = i + 2) {
			sum = calculatorExecute(sum, splitData[i], Integer.valueOf(splitData[i + 1]));
		}

		return sum;
	}

	private int calculatorExecute(int firstNumber, String operator, int secondNumber) {

		if (operator.equals("*")) {
			return multiply(firstNumber, secondNumber);
		}

		if (operator.equals("/")) {
			return divide(firstNumber, secondNumber);
		}

		if (operator.equals("-")) {
			return subtract(firstNumber, secondNumber);
		}

		if (operator.equals("+")) {
			return add(firstNumber, secondNumber);
		}

		throw new IllegalArgumentException();
	}
}
