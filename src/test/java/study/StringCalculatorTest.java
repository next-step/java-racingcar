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
}
