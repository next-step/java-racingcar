package step1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static step1.ScaleRule.FINAL_RESULT;

public class SequentialCalculator {

	private static final int NUMBER_OPERATOR_SIZE_DIFF = 1;
	private static final int NUMBER_OPERATOR_INDEX_DIFF = 1;

	private BigDecimal result;

	public SequentialCalculator(List<BigDecimal> numbers, List<Operator> operators) {
		validateOperandsAndOperators(numbers, operators);

		// 초기값 설정 이후 연산할 값이 있는지 확인, 연산할 값이 없다면 계산 종료
		result = numbers.get(0);
		if (operators.isEmpty()) {
			return;
		}

		calculateFinalResult(numbers, operators);
	}

	private void validateOperandsAndOperators(List<BigDecimal> numbers, List<Operator> operators) {
		if (numberSizeMinusOneNotEqualsOperatorSize(numbers, operators)) {
			throw new IllegalArgumentException(String.format("입력하신 숫자 개수(%d)와 연산자 개수(%d)를 확인해주세요!",
					numbers.size(), operators.size()));
		}
	}

	private boolean numberSizeMinusOneNotEqualsOperatorSize(List<BigDecimal> numbers,
															List<Operator> operators) {
		return numbers.size() - NUMBER_OPERATOR_SIZE_DIFF != operators.size();
	}

	private void calculateFinalResult(List<BigDecimal> numbers, List<Operator> operators) {
		for (int i = 0, end = operators.size(); i < end; i++) {
			calculateOneStep(operators.get(i), numbers.get(i + NUMBER_OPERATOR_INDEX_DIFF));
		}
	}

	private void calculateOneStep(Operator operator, BigDecimal operand) {
		result = operator.calculate(result, operand);
	}

	public BigDecimal getResult() {
		return result.setScale(FINAL_RESULT.getScale(), RoundingMode.HALF_UP);
	}

}
