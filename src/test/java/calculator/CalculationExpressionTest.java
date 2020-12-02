package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class CalculationExpressionTest {

	@DisplayName("문자열을 받아 사칙 연산 식을 완성 시킨다.")
	@ParameterizedTest
	@MethodSource("playBaseballGameExactedResult")
	void name(String paramExpression, NumberFactor expectedNumber) {

		List<NumberFactor> numbers = Arrays.stream(paramExpression.split(" "))
			.filter(NumberFactorHelper::isNumberFactor)
			.map(NumberFactor::new)
			.collect(Collectors.toList());

		List<OperatorFactor> mathOperators = Arrays.stream(paramExpression.split(" "))
			.filter(OperatorFactorHelper::isOperatorFactor)
			.map(OperatorFactor::new)
			.collect(Collectors.toList());

		CalculationExpression expression = new CalculationExpression(numbers, mathOperators);

		expression.executeAll();
		assertThat(expectedNumber).isEqualTo(expression.getResult());
	}

	public static Stream<Arguments> playBaseballGameExactedResult() {
		return Stream.of(
			Arguments.of("5 * 5 + 1234 + 90", new NumberFactor("1349")),
			Arguments.of("1234 + 90 / 123 + 84", new NumberFactor("94")),
			Arguments.of("5 * 1", new NumberFactor("5")),
			Arguments.of("5 * 10", new NumberFactor("50"))
		);
	}
}
