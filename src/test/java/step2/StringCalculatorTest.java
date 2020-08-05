package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;


class StringCalculatorTest {
	StringCalculator stringCalculator = new StringCalculator();

	@DisplayName(value = "사칙연산 수행 후 올바른 값 반환 테스트")
	@Test
	void getRightResult() {
		String str = "2 + 3 * 4 / 2";
		assertThat(stringCalculator.getResult(str))
				.isNotEmpty()
				.containsPattern(Pattern.compile("^[0-9]+$"));
	}

	@DisplayName(value = "사칙연산 실패 에러 발생 테스트")
	@Test
	void getFailResult() {
		String str = "  ";
		assertThatIllegalArgumentException().isThrownBy(() -> { stringCalculator.getResult(str); })
				.withMessage("입력 값이 null이거나 빈 공백 문자");
	}

	@DisplayName(value = "각 연산자별 사칙연산 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"+", "-", "*", "/"})
	void calculate(String op) {
		int num1 = 2, num2 = 3;
		assertThat(stringCalculator.calculate(num2, op, num1)).isNotEmpty();
	}

	@DisplayName(value = "빈 공백 입력 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"", "   "})
	void isEmpty(String str) {
		assertTrue(stringCalculator.isEmpty(str));
	}

	@DisplayName(value = "덧셈 테스트")
	@Test
	void addition() {
		assertThat(stringCalculator.addition(102, 10))
				.isEqualTo("112")
				.isNotEmpty();
	}

	@DisplayName(value = "뺄셈 테스트")
	@Test
	void subtraction() {
		assertThat(stringCalculator.subtraction(102, 10))
				.isEqualTo("92")
				.isNotEmpty();
	}

	@DisplayName(value = "곱셈 테스트")
	@Test
	void multiplication() {
		assertThat(stringCalculator.multiplication(102, 10))
				.isEqualTo("1020")
				.isNotEmpty();
	}

	@DisplayName(value = "나눗셈 테스트")
	@Test
	void division() {
		assertThat(stringCalculator.division(100, 10))
				.isEqualTo("10")
				.isNotEmpty();
	}

	@DisplayName(value = "나눗셈 분모가 0인 경우 에러 발생 테스트")
	@Test
	void divisionError() {
		assertThatThrownBy(() -> {
			stringCalculator.division(1, 0);
		}).isInstanceOf(ArithmeticException.class);
	}

	@DisplayName(value = "사칙연산 기호가 아닌 경우 에러 발생 테스트")
	@Test
	void notOperator() {
		assertThatThrownBy(() -> {
			stringCalculator.calculate(2, "#", 6);
		}).isInstanceOf(IllegalArgumentException.class);
	}
}