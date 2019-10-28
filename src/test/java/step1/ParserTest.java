package step1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class ParserTest {

	private Parser parser;

	@Test
	void 공백이_몇_개가_있건_파싱이_성공한다() {
		// given
		String inputString = "3    + 7";

		// when
		parser = new Parser(inputString);

		// then
		assertThat(parser.getNumbers()).containsExactly(new BigDecimal("3"), new BigDecimal("7"));
		assertThat(parser.getOperators()).containsExactly(Operator.PLUS);
	}

	@ParameterizedTest
	@CsvSource({"+,PLUS", "-,MINUS", "*,MULTIPLY", "/,DIVIDE"})
	void 네_종류의_사칙연산_파싱이_성공한다(String operatorExpression, Operator operator) {
		// given
		String inputString = String.format("1 %s 2", operatorExpression);

		// when
		parser = new Parser(inputString);

		// then
		assertThat(parser.getOperators()).containsExactly(operator);
	}

	@Test
	void 구분된_원소개수가_잘못되었으면_파싱이_실패한다() {
		// given
		String inputString = "3 + 7 -";

		// when & then
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			parser = new Parser(inputString);
		});
	}

	@Test
	void 잘못된_숫자가_있으면_파싱이_실패한다() {
		// given
		String inputString = "three + 7";

		// when & then
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			parser = new Parser(inputString);
		});
	}

	@Test
	void 잘못된_연산자가_있으면_파싱이_실패한다() {
		// given
		String inputString = "3 % 7";

		// when & then
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			parser = new Parser(inputString);
		});
	}

}
