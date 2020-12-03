package calculator;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class AccumulatorTest {

	private static final Long INIT_VALUE = 5L;
	private Accumulator accumulator;

	@BeforeEach
	void setUp() {
		accumulator = Accumulator.of(INIT_VALUE);
	}

	@Test
	@DisplayName("연산자가 적용되는지 확인해보는 테스트")
	void applyOperator_expectException() {
		// given
		Operator unsupportedOperator = (firstOperand, secondOperand) -> {
			throw new UnsupportedOperationException();
		};

		// when
		ThrowableAssert.ThrowingCallable callable = () -> accumulator.applyOperator(unsupportedOperator, 123L);

		// then
		assertThatExceptionOfType(UnsupportedOperationException.class).isThrownBy(callable);
	}


	@Test
	@DisplayName("합연산을 2회 실행하여 누산이 되는지 확인")
	void applyOperator_plus() {
		// given
		Operator plusOperator = (firstOperand, secondOperand) -> firstOperand + secondOperand;

		// when
		accumulator.applyOperator(plusOperator, 3L);
		accumulator.applyOperator(plusOperator, 4L);
		Long result = accumulator.getResult();

		// then
		assertThat(result).isEqualTo(INIT_VALUE + 3L + 4L);
	}

	@ParameterizedTest
	@CsvSource(value = {"PLUS,7,12", "MINUS,5,0"})
	@DisplayName("OperatingEntry 를 이용한 누산 테스트")
	void applyOperatorEntry(FourRuleOperator fourRuleOperator, Long operand, Long expected) {
		// given
		OperatingEntry operatingEntry = OperatingEntry.of(fourRuleOperator, operand);

		// when
		accumulator.applyOperatingEntry(operatingEntry);
		Long result = accumulator.getResult();

		// then
		assertThat(result).isEqualTo(expected);
	}
}