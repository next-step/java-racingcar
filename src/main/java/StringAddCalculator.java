import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	private static String DEFAULT_PATTERN =  ",|:";
	private static Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

	static int splitAndSum(String textInput) {
		int answer = 0;
		if(isaBoolean(textInput))
			return 0;
		String[] tokens = customDelimiterSplit(textInput);
		for(String token : tokens) {
			answer += getParseInt(token);
			isPositive(answer);
		}
		return answer;
	}

	private static void isPositive(int answer) {
		if(answer < 0) {
			throw new RuntimeException();
		}
	}

	private static int getParseInt(String token) {
		return Integer.parseInt(token);
	}

	private static String[] customDelimiterSplit(String token) {
		Matcher m = CUSTOM_PATTERN.matcher(token);
		if (m.find()) {
			String customDelimiter = m.group(1);
			return m.group(2).split(customDelimiter);
		}
		return token.split(DEFAULT_PATTERN);
	}

	private static boolean isaBoolean(String textInput) {
		return textInput == null || textInput.isEmpty() ;
	}
}
