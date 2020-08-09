package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
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

	@DisplayName(value = "사칙연산 실패 에러 발생 조건 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"  ", "+", "* 3 ", " 4", "* 4 4", "1+2", "+3-2", "4.5 + 5.5", "4 - 2 *"})
	void getFailResult(String str) {
		assertThat(stringCalculator.isPossibleCalculate(str)).isFalse();
	}

	@DisplayName(value = "각 연산자별 사칙연산 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"+", "-", "*", "/"})
	void calculate(String op) {
		int num1 = 2, num2 = 3;
		assertThat(stringCalculator.calculate(num2, op, num1)).isNotEmpty();
	}

	@DisplayName(value = "덧셈 테스트")
	@ParameterizedTest
	@CsvSource(value = {"2 + 3=5", "1 + 1 + 10000=10002", "0 + 999=999", "1=1"}, delimiter = '=')
	void addition(String value, String expected) {
		assertThat(stringCalculator.getResult(value))
				.isEqualTo(expected)
				.isNotEmpty();
	}

	@DisplayName(value = "뺄셈 테스트")
	@Test
	void subtraction() {
		assertThat(stringCalculator.calculate(102, "-", 10))
				.isEqualTo("-92")
				.isNotEmpty();
	}

	@DisplayName(value = "곱셈 테스트")
	@Test
	void multiplication() {
		assertThat(stringCalculator.calculate(102, "*", 10))
				.isEqualTo("1020")
				.isNotEmpty();
	}

	@DisplayName(value = "나눗셈 테스트")
	@Test
	void division() {
		assertThat(stringCalculator.calculate(10, "/", 102))
				.isEqualTo("10")
				.isNotEmpty();
	}

	@DisplayName(value = "나눗셈 분모가 0인 경우 에러 발생 테스트")
	@Test
	void divisionError() {
		assertThatThrownBy(() -> {
			stringCalculator.calculate(0, "/", 102);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName(value = "사칙연산 기호가 아닌 경우 에러 발생 테스트")
	@Test
	void notOperator() {
		assertThatThrownBy(() -> {
			stringCalculator.calculate(2, "#", 6);
		}).isInstanceOf(IllegalArgumentException.class);
	}
}