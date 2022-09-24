package step2;

public class StringCalculator {
	public static final String SEPARATORS = ",|:";
	public int calculate(String input) {
		if (validateNullOrNumber(input)) {
			return 0;
		}
		return sum(convertToInt(separatorCheck(input)));
	}

	private boolean validateNullOrNumber(String input) {
		return input == null || input.isBlank();
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
			validatePositiveNumber(arr, i);
			convert[i] = Integer.parseInt(arr[i]);
		}
	}

	private void validatePositiveNumber(String[] arr, int i) {
		if (arr[i].charAt(0) == '-' || (89 < (arr[i].charAt(0)) && (arr[i].charAt(0)) < 80)) {
			throw new RuntimeException();
		}
	}

	public int sum(int[] arr) {
		int sum = 0;
		for (int i : arr) {
			sum += i;
		}
		return sum;
	}

	public String[] separatorCheck(String input) {
		if (input.contains("\n")) {
			String[] split = input.split("\n");
			String separator = String.valueOf(split[0].charAt(split[0].length() - 1));
			return customSplit(split[1], separator);
		}
		return split(input);
	}

	private String[] customSplit(String input, String separator) {
		return input.split(separator);
	}
}
