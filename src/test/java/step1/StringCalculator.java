package step1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.assertj.core.api.Assertions.*;

class StringCalculator {

	private Deque<Integer> numbers = new ArrayDeque<>();

	private Deque<String> operators = new ArrayDeque<>();

	private StringBuilder sb = new StringBuilder();

	@ParameterizedTest
	@CsvSource(value = {"1,2,3", "9,8,17"})
	void plus(int left, int right, int answer) {
		assertThat(left + right).isEqualTo(answer);
	}

	@ParameterizedTest
	@CsvSource(value = {"5,2,3", "13,3,10"})
	void minus(int left, int right, int answer) {
		assertThat(left - right).isEqualTo(answer);
	}

	@ParameterizedTest
	@CsvSource(value = {"7,4,28", "21,3,63"})
	void multiply(int left, int right, int answer) {
		assertThat(left * right).isEqualTo(answer);
	}

	@ParameterizedTest
	@CsvSource(value = {"16,4,4", "21,3,7"})
	void divide(int left, int right, int answer) {
		assertThat(left * right).isEqualTo(answer);
	}

	@Test
	void checkNullString() {
		String input = null;
		assertThatThrownBy(() -> {
			if (input == null || input.equals("")) {
				throw new IllegalArgumentException();
			}
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@CsvSource(value = {"1 + 2:1+2", "5- 4:5-4"}, delimiter = ':')
	void removeSpaceChar(String param, String result) {
		param = param.replaceAll(" ", "");
		assertThat(param).isEqualTo(result);
	}

	@Test
	void checkOperatorYn() {
		char ch = '&';
		assertThatThrownBy(() -> {
			if (ch != '+' && ch != '-' && ch != '*' && ch != '/' ) {
				throw new IllegalArgumentException();
			}
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@CsvSource(value = {"2+3*4/2, 10", "18 / 3 * 2 + 22 - 7, 27"})
	void main(String input, int answer) {
		checkNullString(input);
		splitString(input);
		int result = calculate();
		assertThat(result).isEqualTo(answer);
	}

	void checkNullString(String input) {
		if (input == null || input.equals("")) {
			throw new IllegalArgumentException();
		}
	}

	private void splitString(String input) {
		input = removeSpaceChar(input);
		checkStringValidation(input);

		for (char ch : input.toCharArray()) {
			storeNumberAndOperator(ch);
		}
		numbers.offerLast(Integer.parseInt(sb.toString()));
	}

	private String removeSpaceChar(String input) {
		return input.replaceAll(" ", "");
	}

	private void checkStringValidation(String input) {
		String[] numbers = input.split("\\+|-|\\*|/");

		for (String number : numbers) {
			isNumeric(number);
		}
	}

	private void isNumeric(String number) {
		try {
			Integer.parseInt(number);
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
	}

	private void storeNumberAndOperator(char ch) {
		if (checkOperatorYn(ch)) {
			numbers.offerLast(Integer.parseInt(sb.toString()));
			operators.offerLast(String.valueOf(ch));
			sb = new StringBuilder();
			return;
		}

		sb.append(ch);
	}

	private boolean checkOperatorYn(char ch) {
		if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
			return true;
		}
		return false;
	}

	private int calculate() {
		int result = numbers.pollFirst();

		while (!numbers.isEmpty()) {
			result = branchOffOperator(result, numbers.pollFirst(), operators.pollFirst());
		}

		return result;
	}

	private int branchOffOperator(int left, int right, String operator) {
		if (operator.equals("+")) {
			return plus(left, right);
		}

		if (operator.equals("-")) {
			return minus(left, right);
		}

		if (operator.equals("*")) {
			return multiply(left, right);
		}

		if (operator.equals("/")) {
			return divide(left, right);
		}

		return 0;
	}

	private int plus(int left, int right) {
		return left + right;
	}

	private int minus(int left, int right) {
		return left - right;
	}

	private int multiply(int left, int right) {
		return left * right;
	}

	private int divide(int left, int right) {
		return left / right;
	}

}