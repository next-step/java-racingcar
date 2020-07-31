package calculator.util;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.IntStream;

public class OperationOperandSeparator {
	public static List<String> getOperands(String[] splittedValueOfUserInput) {
		return IntStream.range(0, splittedValueOfUserInput.length)
						.filter(i -> i == 0 || i % 2 == 0)
						.mapToObj(i -> splittedValueOfUserInput[i])
						.collect(toList());
	}

	public static List<String> getOperations(String[] splittedValueOfUserInput) {
		return IntStream.range(0, splittedValueOfUserInput.length)
						.filter(i -> i != 0 && i % 2 == 1)
						.mapToObj(i -> splittedValueOfUserInput[i])
						.collect(toList());
	}
}
