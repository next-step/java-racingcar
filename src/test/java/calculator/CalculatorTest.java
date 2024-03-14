package calculator;

import static calculator.Calculator.*;
import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

	@Test
	void 문자_하나() {
		assertThat(calculate("1")).isEqualTo(1);
	}

	@Test
	void null_값_빈문자() {
		assertThat(calculate(null)).isEqualTo(0);
		assertThat(calculate("")).isEqualTo(0);
	}

	@Test
	void 컴마_구분자() {
		assertThat(calculate("1,2")).isEqualTo(3);
	}
}
