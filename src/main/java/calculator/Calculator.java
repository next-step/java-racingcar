package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
	public static final String FIXED_DELIMITER = ",|:";
	public static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

	public static int cal(String fullText) {
		if (isBlank(fullText)) {
			return 0;
		}

		Matcher matcher = getMatcher(fullText);
		String delimiter = FIXED_DELIMITER;
		if (matcher.find()){
			fullText = matcher.group(2);
			delimiter = matcher.group(1);
		}

		return sum(toIntegerList(split(fullText, delimiter)));
	}

	private static Matcher getMatcher(String fullText) {
		return CUSTOM_PATTERN.matcher(fullText);
	}

	private static boolean isBlank(String fullText) {
		return fullText == null || fullText.isBlank();
	}

	private static String[] split(String fullText, String delimiter) {
		return fullText.split(delimiter);
	}

	private static List<PositiveNumber> toIntegerList(String[] textArray) {
		int[] intArray = new int[textArray.length];
		List<PositiveNumber> integerList = new ArrayList<>();
 		for (int i = 0; i < intArray.length; i++) {
			integerList.add(getNumber(textArray[i]));
		}
		return integerList;
	}

	private static PositiveNumber getNumber(String text) {
		PositiveNumber positiveNumber = new PositiveNumber(Integer.parseInt(text));
		return positiveNumber;
	}

	private static int sum(List<PositiveNumber> positiveNumberList) {
		int sum = 0;
		for (PositiveNumber positiveNumber : positiveNumberList) {
			sum += positiveNumber.getNumber();
		}
		return sum;
	}
}
