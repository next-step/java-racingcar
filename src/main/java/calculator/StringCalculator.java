package calculator;

import calculator.exception.InvalidFormulaException;

import java.util.LinkedList;
import java.util.Queue;

public class StringCalculator {

	private Queue<Integer> numbers;
	private Queue<String> operators;

	public StringCalculator() {
		numbers = new LinkedList<>();
		operators = new LinkedList<>();
	}

	public int calculate(String inputText) {
		validateInputText(inputText);
		initializeNumbersAndOperators(inputText);
		return execute();
	}

	private int execute() {
		int result = numbers.poll();
		while (!numbers.isEmpty()) {
			StringOperator operator = StringOperator.of(operators.poll());
			result = operator.calculate(result, numbers.poll());
		}
		return result;
	}

	private void initializeNumbersAndOperators(String inputText) {
		String[] tokens = inputText.split(" ");
		for (String token : tokens) {
			addNumberOrOperatorBy(token);
		}
	}

	private void addNumberOrOperatorBy(String token) {
		if (isNumeric(token)) {
			numbers.add(Integer.parseInt(token));
			return;
		}
		operators.add(token);
	}

	private void validateInputText(String inputText) {
		if (isBlank(inputText) || isNotStartsWithNumber(inputText)) {
			throw new InvalidFormulaException();
		}
	}

	private boolean isBlank(String inputText) {
		return inputText == null || inputText.isEmpty();
	}

	private boolean isNotStartsWithNumber(String inputText) {
		return !Character.isDigit(inputText.charAt(0));
	}

	private static boolean isNumeric(String token) {
		try {
			Integer.parseInt(token);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
