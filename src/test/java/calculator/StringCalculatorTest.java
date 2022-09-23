package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

	StringCalculator stringCalculator = new StringCalculator();

	@DisplayName("빈 문자열은 0으로 취급한다")
	@Test
	void consider_blank_as_zero() {
		assertThat(stringCalculator.calculate(null)).isZero();
		assertThat(stringCalculator.calculate("")).isZero();
	}

	@DisplayName("문자열에서 숫자를 분리해 더한다")
	@Test
	void split_and_sum() {
		assertThat(stringCalculator.calculate("1,2,3")).isEqualTo(6);
	}
}
