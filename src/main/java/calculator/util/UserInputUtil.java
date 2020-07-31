package calculator.util;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import calculator.exception.CalculatorException;

public final class UserInputUtil {
	private UserInputUtil() {
		throw new CalculatorException("생성 불가능한 유틸 클래스입니다.");
	}

	public static List<String> getOperands(String userInput) {
		return getValuesByFiltering(userInput, i -> i == 0 || i % 2 == 0);
	}

	public static List<String> getSigns(String userInput) {
		return getValuesByFiltering(userInput, i -> i != 0 && i % 2 == 1);
	}

	private static List<String> getValuesByFiltering(String userInput, Predicate<Integer> filter) {
		String[] splittedValueOfUserInput = userInput.split("\\s+");
		return IntStream.range(0, splittedValueOfUserInput.length)
						.filter(i -> filter.test(i))
						.mapToObj(i -> splittedValueOfUserInput[i])
						.collect(toList());
	}


}
