package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

	@DisplayName("빈 문자열 또는 null 값인 경우 0을 반환한다")
	@Test
	void NullOrBlank() {
		assertThat(StringCalculator.cal(null)).isEqualTo(0);
		assertThat(StringCalculator.cal("")).isEqualTo(0);
	}
}