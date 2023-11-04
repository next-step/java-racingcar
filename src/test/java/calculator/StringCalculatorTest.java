package calculator;

import static calculator.StringCalculator.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

	@DisplayName("빈 문자열 또는 null 값인 경우 0을 반환한다")
	@Test
	void NullOrBlank() {
		assertThat(cal(null)).isEqualTo(0);
		assertThat(cal("")).isEqualTo(0);
	}

	@DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다")
	@Test
	void oneStringToNum() {
		assertThat(cal("3")).isEqualTo(3);
	}

	@DisplayName("음수를 전달할 경우 RuntimeException 예외를 던진다")
	@Test
	void negativeNumException() {
		assertThatThrownBy(() -> cal("-3"))
				.isInstanceOf(RuntimeException.class);
	}
}