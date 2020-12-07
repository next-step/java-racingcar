package step2;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringCalculator {
	private static final String SPACE = " ";
	private static final int MIN_INPUT_STRINGS_SIZE = 3;
	private final Operands operands;
	private final Operators operators;

	private StringCalculator(Operands operands, Operators operators) {
		this.operands = operands;
		this.operators = operators;
	}

	public static StringCalculator create(String input) {
		validateInput(input);

		String[] inputStrings = splitBySpace(input);
		Map<OperationElement, List<String>> classTypeGroups = groupingByClassType(inputStrings);

		return new StringCalculator(
			Operands.create(classTypeGroups.get(OperationElement.OPERAND)),
			Operators.create(classTypeGroups.get(OperationElement.OPERATOR))
		);
	}

	static void validateInput(String input) {
		if (isEmpty(input)) {
			throw new IllegalArgumentException(Message.INPUT_STRING);
		}
	}

	private static boolean isEmpty(String string) {
		return Objects.isNull(string) || string.length() == 0;
	}

	static String[] splitBySpace(String input) {
		String[] inputStrings = input.split(SPACE);
		validateInputStrings(inputStrings);

		return inputStrings;
	}

	private static void validateInputStrings(String[] strings) {
		if (isLessThanMinSize(strings.length) || isNotSizeToMakeFormula(strings.length)) {
			throw new IllegalArgumentException(Message.INPUT_WRONG_STRING);
		}
	}

	private static boolean isLessThanMinSize(int size) {
		return size < MIN_INPUT_STRINGS_SIZE;
	}

	private static boolean isNotSizeToMakeFormula(int size) {
		return isEven(size);
	}

	private static boolean isEven(int no) {
		return no % 2 == 0;
	}

	static Map<OperationElement, List<String>> groupingByClassType(String[] strings) {
		return IntStream.range(0, strings.length)
			.boxed()
			.collect(
				Collectors.groupingBy(
					OperationElement::classifyClassTypeByEvenOrOdd,
					Collectors.mapping(index -> strings[index], Collectors.toList())
				));
	}

	public int calculate() {
		Operand result = operands.poll();

		while (!operators.isEmpty()) {
			result = operators.poll().operate(result, operands.poll());
		}

		return result.getValue();
	}
}
