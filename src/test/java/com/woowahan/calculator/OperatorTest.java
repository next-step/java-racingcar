package com.woowahan.calculator;

import static org.assertj.core.api.BDDAssertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class OperatorTest {

	@DisplayName("Operator PLUS 항목의 operator필드는 덧셈기능을 하는 인터페이스 구현체다.")
	@ParameterizedTest
	@CsvSource(value = {"1:2:3", "-7:9:2", "-3:-5:-8"}, delimiter = ':')
	public void operatorPlus(long value1, long value2, long expected) {

		//when
		long result = Operator.PLUS.getOperator().applyAsLong(value1, value2);

		//then
		then(result).isEqualTo(expected);
	}

	@DisplayName("Operator MINUS 항목의 operator필드는 뺄셈기능을 하는 인터페이스 구현체다.")
	@ParameterizedTest
	@CsvSource(value = {"3:2:1", "5:-3:8", "-9:-6:-3"}, delimiter = ':')
	public void operatorMinus(long value1, long value2, long expected) {

		//when
		long result = Operator.MINUS.getOperator().applyAsLong(value1, value2);

		//then
		then(result).isEqualTo(expected);
	}

	@DisplayName("Operator MULTIPLY 항목의 operator필드는 곱셈기능을 하는 인터페이스 구현체다.")
	@ParameterizedTest
	@CsvSource(value = {"3:2:6", "5:-3:-15", "-9:-6:54"}, delimiter = ':')
	public void operatorMultiply(long value1, long value2, long expected) {

		//when
		long result = Operator.MULTIPLY.getOperator().applyAsLong(value1, value2);

		//then
		then(result).isEqualTo(expected);
	}

	@DisplayName("Operator DIVIDE 항목의 operator필드는 나눗셈기능을 하는 인터페이스 구현체다.")
	@ParameterizedTest
	@CsvSource(value = {"15:3:5", "12:-4:-3", "-25:-5:5"}, delimiter = ':')
	public void operatorDivde(long value1, long value2, long expected) {

		//when
		long result = Operator.DIVIDE.getOperator().applyAsLong(value1, value2);

		//then
		then(result).isEqualTo(expected);
	}

	@DisplayName("Operator getOperator 메서드에 사칙 연산 기호 문자열을 전달하면 알맞는 Operator를 반환한다.")
	@ParameterizedTest
	@MethodSource("argGetOperator")
	public void operatorGetOperator(String value, Operator expected) {

		//when
		Operator result = Operator.getOperator(value);

		//then
		then(result).isEqualTo(expected);
	}

	public static Stream<Arguments> argGetOperator() {
		return Stream.of(
			Arguments.of("+", Operator.PLUS),
			Arguments.of("-", Operator.MINUS),
			Arguments.of("*", Operator.MULTIPLY),
			Arguments.of("/", Operator.DIVIDE)
		);
	}

	@DisplayName("Operator getOperator 메서드에 사칙 연산 기호가 아닌 문자열을 전달하면 IllegalArgumentException이 발생한다.")
	@ParameterizedTest
	@ValueSource(strings = {"a", "bc", "!", "%"})
	public void operatorGetOperatorThrow(String value) {

		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				Operator.getOperator(value);
			}).withMessage(Validator.MSG_NOT_FOUND_OPERATOR);
	}

}