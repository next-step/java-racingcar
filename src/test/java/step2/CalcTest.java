package step2;

import static org.assertj.core.api.Assertions.assertThat;
import org.assertj.core.util.Strings;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class CalcTest {
	Calc calcString = new Calc();

	@Test
	void getRightResult() {
		String str = "2 + 3 * 4 / 2";
		assertThat(calcString.getResult(str))
				.isNotEmpty()
				.containsPattern(Pattern.compile("^[0-9]+$"))
				;
	}

	@Test
	void getFailResult() {
		String str = "  ";
		assertThatIllegalArgumentException().isThrownBy(() -> { calcString.getResult(str); })
				.withMessage("입력 값이 null이거나 빈 공백 문자")
				;
	}

	@ParameterizedTest
	@ValueSource(strings = {"+", "-", "*", "/"})
	void calculate(String op) {
		int num1 = 2, num2 = 3;
		assertThat(calcString.calculate(num2, op, num1))
				.isNotEmpty()
				;
	}

	@ParameterizedTest
	@ValueSource(strings = {"", "   "})
	void isEmpty(String str) {
		assertTrue(calcString.isEmpty(str));
	}


	@Test
	void addition() {
		assertThat(calcString.addition(102, 10))
				.isEqualTo("112")
				.isNotEmpty();
	}

	@Test
	void subtraction() {
		assertThat(calcString.subtraction(102, 10))
				.isEqualTo("92")
				.isNotEmpty();
	}

	@Test
	void multiplication() {
		assertThat(calcString.multiplication(102, 10))
				.isEqualTo("1020")
				.isNotEmpty();
	}

	@Test
	void division() {
		assertThat(calcString.division(102, 10))
				.isEqualTo("10")
				.isNotEmpty();
	}
}