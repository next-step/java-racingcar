package step2;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static step2.StringAddCalculator.*;

import org.junit.jupiter.api.Test;

// 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
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
	void 커스텀_구분자_테스트() {
		assertThat(calculate("//hello\n1hello2,3:4hello7")).isEqualTo(17);
	}
}