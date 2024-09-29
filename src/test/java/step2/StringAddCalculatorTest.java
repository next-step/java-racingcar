package step2;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static step2.StringAddCalculator.*;

import org.junit.jupiter.api.Test;

class StringAddCalculatorTest {
	@Test
	void 숫자하나_숫자반환() {
		assertThat(calculate("1")).isEqualTo(1);
	}

	@Test
	void 빈문자열_null_0반환() {
		assertThat(calculate("")).isEqualTo(0);
		assertThat(calculate(null)).isEqualTo(0);
	}

	@Test
	void 컴마로_분할해서_더하기() {
		assertThat(calculate("1,2,3")).isEqualTo(6);
	}

	@Test
	void 콜론으로_분할해서_더하기() {
		assertThat(calculate("1:2:3")).isEqualTo(6);
	}

	@Test
	void 커스텀_구분자_테스트() {
		assertThat(calculate("//hello\n1hello2,3:4hello7")).isEqualTo(17);
	}

	@Test
	void 숫자이외의값_음수_에러_테스트() {
		assertThatThrownBy(() -> calculate("1,-2,3,4")).isInstanceOf(RuntimeException.class);
		assertThatThrownBy(() -> calculate("1,-2,이상한값,4")).isInstanceOf(RuntimeException.class);
		assertThatThrownBy(() -> calculate("%/unExpectedValue\r1,-2,3,4")).isInstanceOf(RuntimeException.class);
	}
}