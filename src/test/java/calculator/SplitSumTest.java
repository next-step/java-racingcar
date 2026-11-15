package calculator;

import static calculator.Calculator.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SplitSumTest {

	@Test
	void 쉼표_구분자로_나눈_숫자의합을_반환한다() {
		assertThat(calc("1,2")).isEqualTo(3);
	}

	@Test
	void 콜론_구분자로_나눈_숫자의합을_반환한다() {
		assertThat(calc("1:2")).isEqualTo(3);
	}

	@Test
	void 쉼표_콜론_구분해서_숫자의합을_반환한다() {
		assertThat(calc("1,2:3")).isEqualTo(6);
	}

	@Test
	void 숫자하나일경우_그대로_반환한다() {
		assertThat(calc("3")).isEqualTo(3);
	}

	@Test
	void 빈문자열이면_0을_반환한다() {
		assertThat(calc("")).isEqualTo(0);
	}

	@Test
	void 커스텀구분자로_나눈_숫자의합을_반환한다() {
		assertThat(calc("//;\n1;2;3")).isEqualTo(6);
	}

	@Test
	void 음수면_RuntimeException을_던진다() {
		assertThatThrownBy(() -> calc("-2"))
			.isInstanceOf(RuntimeException.class);
	}
}
