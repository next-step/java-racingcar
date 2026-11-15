package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static calculator.StringAddCalculator.cal;

public class StringAddCalculatorTest {
	

	@Test
	void null_또는_빈문자열() {
		assertThat(cal("")).isEqualTo(0);
	}
}
