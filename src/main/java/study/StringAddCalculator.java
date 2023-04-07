package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 기능 요구사항
 * 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
 * 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
 * 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
 * <p>
 * 프로그래밍 요구사항
 * 메소드가 너무 많은 일을 하지 않도록 분리하기 위해 노력해 본다.
 */
public class StringAddCalculator {
	private static final String DEFAULT_DELIMITERS = ",|:";
	private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
	private static final Pattern patternCache = Pattern.compile(CUSTOM_DELIMITER_PATTERN);

	public static int splitAndSum(String text) {
		if (isTextNullOrEmpty(text)) {
			return 0;
		}
		return sum(toPositiveInts(splitText(text)));
	}

	private static boolean isTextNullOrEmpty(String text) {
		return text == null || text.isEmpty();
	}

	private static String[] splitText(String text) {
		Matcher m = patternCache.matcher(text);
		String delimiters = DEFAULT_DELIMITERS;
		if (m.find()) {
			delimiters += '|' + m.group(1);
			return m.group(2).split(delimiters);
		}
		return text.split(delimiters);
	}

	private static int sum(int[] numbers) {
		int sum = 0;
		for (int number : numbers) {
			sum += number;
		}
		return sum;
	}

	private static int[] toPositiveInts(String[] strNumbers) {
		int[] numbers = new int[strNumbers.length];
		for (int i = 0; i < strNumbers.length; i++) {
			int number = toPositiveInt(strNumbers[i]);
			numbers[i] = number;
		}
		return numbers;
	}

	private static int toPositiveInt(String strNumber) {
		int number = Integer.parseInt(strNumber);
		if (number < 0) {
			throw new RuntimeException("음수를 입력할 수 없습니다." + number);
		}
		return number;
	}
}
