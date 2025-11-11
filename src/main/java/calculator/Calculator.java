package calculator;

public class Calculator {
	private final Delimiter delimiter;

	public Calculator(Delimiter delimiter) {
		this.delimiter = delimiter;
	}

	public int calculate(String input) {
		// 1. null/빈 문자열 체크
		if (isBlankOrNull(input)) {
			return 0;
		}

		// 2. 구분자 검증
		validateDelimiters(input);

		// 3. 문자열 분리
		String[] tokens = delimiter.split(input);

		// 4. 각 토큰 음수 검증
		for (String token : tokens) {
			validatePositiveNumber(token);
		}

		// 5. 합 계산
		return sum(tokens);
	}

	private boolean isBlankOrNull(String input) {
		return input == null || input.isEmpty() || input.equals("null");
	}

	private void validateDelimiters(String input) {
		String regex = "[\\d" + delimiter.getDelimiter() + "]+";
		if (!input.matches(regex)) {
			throw new IllegalArgumentException("허용되지 않은 구분자가 포함되어 있습니다.");
		}
	}

	private void validatePositiveNumber(String token) {
		int number = Integer.parseInt(token);

		if (number < 0) {
			throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
		}
	}

	private int sum(String[] tokens) {
		int result = 0;
		for (String token : tokens) {
			result += Integer.parseInt(token);
		}
		return result;
	}
}
