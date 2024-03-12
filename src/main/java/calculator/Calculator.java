package calculator;

public class Calculator {

	public String calculate(String input) {
		if ( (input == null) || (input.isEmpty()) ) {
			return "0";
		}

		// 숫자 한개만 입력 시 입력값 그대로 반환
		if (isNumber(input)) {
			return input;
		}

		String[] numbers = CustomSeparator.separateNumbers(input);

		checkInvalidInput(numbers);

		return sum(numbers).toString();
	}

	private void checkInvalidInput(String[] numbers) {
		for (String number : numbers) {
			validateInputNumber(number);
		}
	}

	private void validateInputNumber(String number) {
		if (!isNumber(number) || Integer.valueOf(number) < 0) {
			throw new RuntimeException("음수 or 숫자 이외의 값을 입력하셨습니다.");
		}
	}

	private Integer sum(String[] numbers) {
		int result = 0;
		for (String number : numbers) {
			result += Integer.parseInt(number);
		}

		return result;
	}

	private boolean isNumber(String input) {
		return input != null && input.matches("[-+]?\\d*\\.?\\d+");
	}

}
