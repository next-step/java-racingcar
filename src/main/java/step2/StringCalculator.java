package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	private static final String SEPARATORS = ",|:";
	private static final String CUSTOMSEPARATORS = "//(.)\n(.*)";
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
		if (input.matches(CUSTOMSEPARATORS)) {
			Pattern pattern = Pattern.compile(CUSTOMSEPARATORS);
			Matcher matcher = pattern.matcher(input);
			while (matcher.find()) {
				return customSplit(matcher.group(2), matcher.group(1));
			}
		}
		return split(input);
	}

	private String[] customSplit(String input, String separator) {
		return input.split(separator);
	}
}
