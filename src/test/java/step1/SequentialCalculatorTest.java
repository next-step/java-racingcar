package step1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SequentialCalculatorTest {

	private SequentialCalculator calculator;

	@ParameterizedTest
	@CsvSource({"PLUS,6.0000", "MINUS,-4.0000", "MULTIPLY,5.0000", "DIVIDE,0.2000"})
	@SuppressWarnings("NonAsciiCharacters")
	void 사칙연산이_정상적으로_적용된다(Operator operator, String result) {
		// given
		List<BigDecimal> numbers = Arrays.asList(new BigDecimal("1"), new BigDecimal("5"));
		List<Operator> operators = Collections.singletonList(operator);

		// when
		calculator = new SequentialCalculator(numbers, operators);

		// then
		assertThat(calculator.getResult()).isEqualTo(new BigDecimal(result));
	}

	@Test
	@SuppressWarnings("NonAsciiCharacters")
	void 사칙연산_규칙을_무시하고_순차적으로_계산한다() {
		// given
		List<BigDecimal> numbers = Arrays.asList(new BigDecimal("2"),
				new BigDecimal("3"),
				new BigDecimal("4"),
				new BigDecimal("2"));
		List<Operator> operators = Arrays.asList(Operator.PLUS, Operator.MULTIPLY, Operator.DIVIDE);

		// when
		calculator = new SequentialCalculator(numbers, operators);

		// then
		assertThat(calculator.getResult()).isEqualTo(new BigDecimal("10.0000"));
	}

	@ParameterizedTest
	@CsvSource({"4,0.0000", "5,0.0001", "6,0.0001"})
	@SuppressWarnings("NonAsciiCharacters")
	void 소수점_넷째자리까지_반올림을_한다(String number, String result) {
		// given
		List<BigDecimal> numbers = Arrays.asList(new BigDecimal(number), new BigDecimal("100000"));
		List<Operator> operators = Collections.singletonList(Operator.DIVIDE);

		// when
		calculator = new SequentialCalculator(numbers, operators);

		// then
		assertThat(calculator.getResult()).isEqualTo(new BigDecimal(result));
	}

	@Test
	@SuppressWarnings("NonAsciiCharacters")
	void 피연산자와_연산자_개수가_맞지않으면_계산에_실패한다() {
		// given
		List<BigDecimal> numbers = Arrays.asList(new BigDecimal("10"), new BigDecimal("20"));
		List<Operator> operators = Arrays.asList(Operator.PLUS, Operator.MULTIPLY, Operator.DIVIDE);

		// when & then
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			calculator = new SequentialCalculator(numbers, operators);
		});
	}

}
