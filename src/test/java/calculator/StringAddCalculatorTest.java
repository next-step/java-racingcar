package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static calculator.StringAddCalculator.calculate;

public class StringAddCalculatorTest {
	

	@Test
	void 기본_구분자() {
		assertThat(calculate("1,2")).isEqualTo(3);
		assertThat(calculate("1:2")).isEqualTo(3);
	}
	
	@Test
	void null_또는_빈문자열() {
		assertThat(calculate("")).isEqualTo(0);
		assertThat(calculate(null)).isEqualTo(0);	
	}
}
