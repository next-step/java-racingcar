package nextstep.step2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringCalculator {
	private static final String SPACE = " ";

	public int calculate(String formula) {
		validateCheck(formula);

		String[] formulaArray = getArrayBySpace(formula);
		List<String> numbers = getOddList(formulaArray);
		List<String> operators = getEvenList(formulaArray);

		validateNumber(numbers); // 숫자가 들어와야 한다.
		validateOperator(operators); // 사칙연산이 들어와야 한다.

		return calculate(numbers, operators);
	}

	private String[] getArrayBySpace(String formula) {
		return formula.split(SPACE);
	}

	protected void validateCheck(String formula) {
		if (formula == null || formula.isEmpty())
			throw new IllegalArgumentException("the input value is empty!!");
	}

	private List<String> getEvenList(String[] formulaArray) {
		return IntStream.range(0, formulaArray.length)
					.filter(index -> !isEven(index))
					.mapToObj(index -> formulaArray[index])
					.collect(Collectors.toList());
	}

	private List<String> getOddList(String[] formulaArray) {
		return IntStream.range(0, formulaArray.length)
					.filter(index -> isEven(index))
					.mapToObj(index -> formulaArray[index])
					.collect(Collectors.toList());
	}

	private int calculate(List<String> strList, List<String> operatorList) {
		List<Integer> numbers = strList.stream()
				.map(Integer::parseInt)
				.collect(Collectors.toList());
		return numbers.stream()
				.reduce(numbers.remove(0), (num1, num2) -> Operator.getOperatorBy(operatorList.remove(0)).apply(num1, num2));
	}

	private boolean isEven(int index) {
		return index % 2 == 0;
	}

	protected void validateNumber(List<String> oddArray) {
		boolean allDigit = oddArray.stream().allMatch(oddNum -> oddNum.chars().allMatch(Character::isDigit));
		if (!allDigit) {
			throw new IllegalArgumentException("wrong number!!");
		}
	}

	protected void validateOperator(List<String> evenArray) {
		evenArray.forEach(Operator::getOperatorBy);
	}
}
