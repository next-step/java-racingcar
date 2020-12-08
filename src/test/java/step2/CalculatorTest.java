package step2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {
	Calculator calculator = new Calculator();

	@DisplayName("실패 테스트 1 : 입력값이 null인 경우")
	@Test
	public void 실패테스트_1() throws Exception {
	    // given
	    // when
	    // then
		assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(null));
	}

	@DisplayName("실패 테스트 2 : 입력값이 빈 문자열인 경우")
	@ParameterizedTest
	@ValueSource(strings = {"", " "})
	public void 실패테스트_2(String expression) throws Exception {
		// given
		// when
		// then
		assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(expression));
	}

	@DisplayName("실패 테스트 3 : 사칙연산 기호가 아닌 경우")
	@ParameterizedTest
	@ValueSource(strings = {"%", "!", "@", "#"})
	public void 실패테스트_3(String symbol) throws Exception {
	    // given
	    // when
	    // then
		assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(symbol));
	}


	@Test
	public void 덧셈_테스트() throws Exception {
	    // given
		long expectedResult = 6;
	    // when
		String expression = "1 + 2 + 3";
		long actualResult = calculator.calculate(expression);
	    // then
		assertThat(actualResult).isEqualTo(expectedResult);
	}
}