package step1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class SequentialCalculator {

	private BigDecimal result;

	public SequentialCalculator(List<BigDecimal> numbers, List<Operator> operators) {
		// 데이터 검증
		validateOperandsAndOperators(numbers, operators);

		// 초기값 설정 이후 연산할 값이 있는지 확인, 연산할 값이 없다면 계산 종료
		this.result = numbers.get(0);
		if (operators.isEmpty()) {
			return;
		}

		// 연산할 값이 있다면 순차적으로 계산을 실행
		calculateFinalResult(numbers, operators);
	}

	private void validateOperandsAndOperators(List<BigDecimal> numbers, List<Operator> operators) {
		if (NumberSizeMinusOneNotEqualsOperatorSize(numbers, operators)) {
			throw new IllegalArgumentException();
		}
	}

	private boolean NumberSizeMinusOneNotEqualsOperatorSize(List<BigDecimal> numbers,
															List<Operator> operators) {
		return numbers.size() - 1 != operators.size();
	}

	private void calculateFinalResult(List<BigDecimal> numbers, List<Operator> operators) {
		for (int i = 0; i < operators.size(); i++) {
			calculateOneStep(operators.get(i), numbers.get(i + 1));
		}
	}

	private void calculateOneStep(Operator operator, BigDecimal operand) {
		result = operator.getOperate().apply(result, operand);
	}

	public BigDecimal getResult() {
		return this.result.setScale(4, RoundingMode.HALF_UP);
	}

}
