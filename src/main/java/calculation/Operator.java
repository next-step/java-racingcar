package calculation;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Operator {
	private static final String OPERATOR_ERROR_MESSAGE = "error : 입력된 연산자는 없습니다.";
	private static final String OPERATOR_PATTERN = "[-/*+]";

	public Operator() {
	}

	public static int operatorCount(Data data) {
		return (int)Arrays.stream(data.getData())
			.filter(i -> Pattern.matches(OPERATOR_PATTERN, i) == true)
			.count();
	}

	public static String findTheOperator(Data data, int operatorIndex) {
		return data.value(operatorIndex);
	}

	public static int findTheOperatorIndex(Data data, int startIndex) {
		return IntStream.range(startIndex, data.size())
			.filter(i -> Pattern.matches(OPERATOR_PATTERN, data.value(i)) == true)
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(OPERATOR_ERROR_MESSAGE));
	}
}
