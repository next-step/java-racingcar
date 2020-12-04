package calculator;

public class Calculator {
	private int firstNumber;
	private String operation;
	private int secondNumber;

	public Calculator(String firstNumber, String operation, String secondNumber) {
		this.firstNumber = Integer.parseInt(firstNumber);
		this.operation = operation;
		this.secondNumber = Integer.parseInt(secondNumber);
	}

	public int calculate() {
		if (isAddition()) {
			return this.firstNumber + this.secondNumber;
		}
		if (isSubtraction()) {
			return this.firstNumber - this.secondNumber;
		}
		if (isMultiplication()) {
			return this.firstNumber * this.secondNumber;
		}
		if (isDivision()) {
			return this.firstNumber / this.secondNumber;
		}
		return 0;
	}

	private boolean isAddition() {
		return this.operation.equals("+");
	}

	private boolean isSubtraction() {
		return this.operation.equals("-");
	}

	private boolean isMultiplication() {
		return this.operation.equals("*");
	}

	private boolean isDivision() {
		return this.operation.equals("/");
	}
}
