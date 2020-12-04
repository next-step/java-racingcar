package calculator.expression;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ExpressionTest {
	@DisplayName("정상적인 문자열 사칙연산 객체 생성")
	@ParameterizedTest
	@ValueSource(strings = {"1 + 2", "1 - 2", "1 * 2", "2 / 1", "1 + 2 * 3", "1 + 2 / 3"})
	void newInstance(String value) {
		//when
		Expression expression = new Expression(value);

		//then
		assertThat(expression).isNotNull();
	}

	@DisplayName("비정상적인 문자열 사칙연산 객체 생성 오류")
	@ParameterizedTest
	@ValueSource(strings = {"1", "1+2", "1 // 2", "2 / 1 4", ""})
	void newInstanceException(String value) {
		assertThatIllegalArgumentException()
				.isThrownBy(() -> new Expression(value))
				.withMessageContaining("비정상적인 문자열 수식입니다.");
	}

	@DisplayName("사칙연산을 진행할 값이 남아있는지 확인")
	@Test
	void hasNextNumber() {
		//given
		String expressionParam = "1 + 2";
		Expression expression = new Expression(expressionParam);

		//when, then
		assertThat(expression.hasNextNumber()).isTrue();
	}

	@DisplayName("사칙연산을 진행할 연산자가 남아있는지 확인")
	@Test
	void hasNextOperator() {
		//given
		String expressionParam = "1 + 2";
		Expression expression = new Expression(expressionParam);

		//when, then
		assertThat(expression.hasNextOperator()).isTrue();
	}
}