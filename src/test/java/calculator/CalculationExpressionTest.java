package calculator;

import com.sun.tools.javac.comp.Check;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculationExpressionTest {

	@DisplayName("문자열 연산식과 예측 결과가 일치하는지 확인한다.")
	@ParameterizedTest
	@MethodSource("calculationExpressionExactedResult")
	void shouldEqualsExpressionResultAndExpectedValue(String paramExpression, NumberFactor expectedNumber) {
		CalculationExpression expression = new CalculationExpression(paramExpression);
		expression.executeAll();
		assertThat(expectedNumber).isEqualTo(expression.getResult());
	}

	public static Stream<Arguments> calculationExpressionExactedResult() {
		return Stream.of(
			Arguments.of("5 + 5 + 5 + 90", new NumberFactor("105")),
			Arguments.of("1234 + 90 / 123 + 84", new NumberFactor("94")),
			Arguments.of("5 / 1", new NumberFactor("5")),
			Arguments.of("5 * 10", new NumberFactor("50"))
		);
	}


	@DisplayName("허용 되지 않은 계산 표현식에 대해서 예외 처리가 작동하고 예상하는 예외 클래스와 일치하는지 확인한다.")
	@ParameterizedTest
	@MethodSource("ExactedException")
	void whenInputFactorNotAllowStringMatchesExpectedExceptionAndMessage(String paramExpression, String message, Class<?> exception) {
		assertThatThrownBy(() -> new CalculationExpression(paramExpression).executeAll())
			.isInstanceOf(exception)
			.hasMessageContaining(message);
	}

	public static Stream<Arguments> ExactedException() {
		return Stream.of(
			Arguments.of("1234 + 90 / 123 + 1.5", "For input string: ", IllegalArgumentException.class),
			Arguments.of("5 5 5 90 * + +", "calculation expression format error", IllegalArgumentException.class),
			Arguments.of("1234 + a / 123 + 84 +", "NumberFactor must be more than OperatorFactor in calculation expression", IllegalArgumentException.class),
			Arguments.of("5 / 0", "/ by zero", ArithmeticException.class)
		);
	}
}
