package step1;

public class StringCalculator {
	String[] inputArray;

	// 실행
	public int run(String input) {
		validate(input);
		inputArray = input.split(" ");

		if (inputArray.length % 2 == 0) {
			throw new IllegalArgumentException();
		}

		int result = 0;
		for (int i = 0, iLen = inputArray.length; i < iLen; i += 2) {
			result = calc(result, i);
		}

		return result;
	}

	// 계산
	private int calc(int result, int index) {
		int num;
		try {
			num = Integer.parseInt(inputArray[index]);
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}

		if (index == 0) {
			return num;
		}
		switch (inputArray[index - 1]) {
			case "+":
				return add(result, num);
			case "-":
				return sub(result, num);
			case "*":
				return multiply(result, num);
			case "/":
				return divide(result, num);
			default:
				throw new IllegalArgumentException();
		}
	}

	// 유효성 체크
	private void validate(String input) {
		if (input == null || input.trim().length() == 0) {
			throw new IllegalArgumentException();
		}
	}

	// 덧셈
	private int add(int a, int b) {
		return a + b;
	}

	// 뺄셈
	private int sub(int a, int b) {
		return a - b;
	}

	// 곱셈
	private int multiply(int a, int b) {
		return a * b;
	}

	// 나눗셈
	private int divide(int a, int b) {
		return a / b;
	}
}
