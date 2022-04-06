package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {
	@Test
	void 빈문자열이거나_Null인_경우() {
		assertThat(StringAddCalculator.splitAndSum("")).isEqualTo(0);
		assertThat(StringAddCalculator.splitAndSum(null)).isEqualTo(0);
	}

	@Test
	void 쉼표_구분자() {
		assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
	}

	@Test
	void 숫자_하나의_문자열() {
		assertThat(StringAddCalculator.splitAndSum("1")).isEqualTo(1);
	}

	@Test
	void 콜론_구분자() {
		assertThat(StringAddCalculator.splitAndSum("2:3")).isEqualTo(5);
	}

	@Test
	void custom_구분자() {
		assertThat(StringAddCalculator.splitAndSum("//-\n1-2-3")).isEqualTo(6);
	}

	@Test
	void 구분자_연속사용_RuntimeException_발생() {
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum("1::2"))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	void custom_구분자포맷이_아닌_구분자_RuntimeException_발생() {
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum("1;2:3"))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	void 음수_RuntimeException_발생() {
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1"))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	void 음수와_custom_구분자_RuntimeException_발생() {
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum("//;\n-1;2;3"))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	void 음수와_custom_구분자가_마이너스일때_RuntimeException_발생() {
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum("//-\n1--2-3"))
			.isInstanceOf(RuntimeException.class);
	}
}