package calculator;

import static calculator.Calculator.*;
import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

	@Test
	void 문자_하나() {
		assertThat(calculate("1")).isEqualTo(1);
		assertThat(calculate("2")).isEqualTo(2);
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

	@Test
	void 콜론_구분자() {
		assertThat(calculate("3:7")).isEqualTo(10);
	}

	@Test
	void 커스텀_구분자() {
		assertThat(calculate("//;\n1;2;3")).isEqualTo(6);
	}

	@Test
	void 음수_예외() throws Exception{
		assertThatThrownBy(() -> calculate("-1,2,3"))
			.isInstanceOf(RuntimeException.class);
	}
}
