package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	public static final int ZERO = 0;
	public static final String DELIMITER = ",|:";
	public static final String NEGATIVE_NUMBER = "음수는 입력할 수 없습니다.";

	public static int calculate(String strNumbers) {
		if(isBlank(strNumbers)) {
			return ZERO;
		}

		return sum(toInts(split(strNumbers)));
	}

	private static String[] split(String strNumbers) {
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(strNumbers);

		if (m.find()) {
			String customDelimiter = m.group(1);
			return m.group(2).split(DELIMITER+"|"+customDelimiter);
		}

		return strNumbers.split(DELIMITER);
	}

	private static boolean isBlank(String strNumbers) {
		return strNumbers == null || strNumbers.isBlank();
	}

	private static List<Integer> toInts(String[] tokens) {
		List<Integer> numbers = new ArrayList<>();

		for (String token : tokens) {
			numbers.add(toInt(token));
		}

		return numbers;
	}

	private static int toInt(String tokens) {
		int number = Integer.parseInt(tokens);

		if (number < 0) {
			throw new IllegalArgumentException(NEGATIVE_NUMBER);
		}

		return number;
	}

	private static int sum(List<Integer> numbers) {
		int result = ZERO;

		for (int number : numbers) {
			result += number;
		}

		return result;
	}
}
