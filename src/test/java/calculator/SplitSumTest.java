package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SplitSumTest {

	@Test
	void 쉼표_구분자로_나눈_숫자의합을_반환한다() {
		assertThat(Calculator.calc("1,2")).isEqualTo(3);
	}

	@Test
	void 콜론_구분자로_나눈_숫자의합을_반환한다() {
		assertThat(Calculator.calc("1:2")).isEqualTo(3);
	}
}
