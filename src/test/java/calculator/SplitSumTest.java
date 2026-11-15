package calculator;

import static calculator.Calculator.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SplitSumTest {

	@ParameterizedTest
	@CsvSource(
		value = {"'1,2',3", "'1:2',3", "'1,2:3',6", "'2',2", "'',0"}
	)
	void 기본구분자로_나눈_숫자의합을_반환한다(String input, int expected) {
		assertThat(calc(input)).isEqualTo(expected);
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

	@Test
	void 숫자가_아닌_값이_입력되면_RuntimeException을_던진다() {
		assertThatThrownBy(() -> calc("h"))
			.isInstanceOf(RuntimeException.class);
	}
}
