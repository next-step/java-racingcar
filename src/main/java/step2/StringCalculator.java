package step2;

public class StringCalculator {
	public static String SEPARATORS = ",|:";
	public int calculate(String input) {
		if (input == null || input.isBlank()) {
			return 0;
		}
		return add(convertToInt(split(separatorCheck(input))));
	}

	public String[] split(String input) {
		return input.split(SEPARATORS);
	}

	public int[] convertToInt(String[] arr) {
		int[] convert = new int[arr.length];
		checkMinusOrNotNumber(arr, convert);
		return convert;
	}

	private void checkMinusOrNotNumber(String[] arr, int[] convert) {
		for (int i = 0; i < arr.length; i++) {
			validMinusOrNotNumber(arr, i);
			convert[i] = Integer.parseInt(arr[i]);
		}
	}

	private void validMinusOrNotNumber(String[] arr, int i) {
		if (arr[i].charAt(0) == '-' || (89 < (arr[i].charAt(0)) && (arr[i].charAt(0)) < 80)) {
			throw new RuntimeException();
		}
	}

	public int add(int[] arr) {
		int sum = 0;
		for (int i : arr) {
			sum += i;
		}
		return sum;
	}

	public String separatorCheck(String input) {
		if (input.contains("\n")) {
			String[] split = input.split("\n");
			String separator = String.valueOf(split[0].charAt(split[0].length() - 1));
			SEPARATORS += "|" + separator;
			return split[1];
		}
		return input;
	}
}
