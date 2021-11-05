package study.calculator;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculatorTest {
	@Test
	@DisplayName("덧셈")
	void plus(){
		MyNumber actual = Calculator.c("1 + 2");
		Assertions.assertThat(actual).isEqualTo(new MyNumber(3));
	}

	@Test
	@DisplayName("뺄셈")
	void minus(){
		MyNumber actual = Calculator.c("3 - 2");
		Assertions.assertThat(actual).isEqualTo(new MyNumber(1));
	}
	@Test
	@DisplayName("곱하기")
	void multiply(){
		MyNumber actual = Calculator.c("3 * 2");
		Assertions.assertThat(actual).isEqualTo(new MyNumber(6));
	}
	@Test
	@DisplayName("나누기")
	void dividedBy(){
		MyNumber actual = Calculator.c("4 / 2");
		Assertions.assertThat(actual).isEqualTo(new MyNumber(2));
	}

	@ParameterizedTest
	@MethodSource("study.calculator.CalculatorTest#dividedByZeroOrNull")
	@DisplayName("분모가 0이거나 숫자가 아닐 경우")
	void dividedByZeroOrNull(String input){
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				Calculator.c("4 / " + input);
			})
		;
	}
	@Test
	@DisplayName("사칙연산기호가_아닌경우")
	void checkOperator(){
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				Calculator.c("4 x 7");
			})
		;
	}


	static Stream<String> dividedByZeroOrNull() {
		return Stream.of(null, "", "  ", "0");
	}
}
