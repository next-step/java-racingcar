package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

	private StringCalculator stringCalculator;

	@BeforeEach
	void init() {
		stringCalculator = new StringCalculator();
	}

	@DisplayName("문자열을 파싱하여 더하기를 하는 테스트")
	@Test
	void plus() {
		String str = "3 + 5";
		Integer result = 8;
		assertThat(stringCalculator.plus(str)).isEqualTo(result);
	}

	@DisplayName("문자열을 파싱하여 빼는 테스트")
	@Test
	void minus() {
		String str = "3 - 5";
		Integer result = -2;
		assertThat(stringCalculator.minus(str)).isEqualTo(result);
	}

	@DisplayName("문자열을 파싱하여 곱하기를 하는 테스트")
	@Test
	void multiply() {
		String str = "3 * 5";
		Integer result = 15;
		assertThat(stringCalculator.multiply(str)).isEqualTo(result);
	}

	@DisplayName("문자열을 파싱하여 나누기를 하는 테스트")
	@Test
	void divide() {
		String str = "6 + 3";
		Integer result = 2;
		assertThat(stringCalculator.divide(str)).isEqualTo(result);
	}
}
