package com.woowahan.calculator;

import static org.assertj.core.api.BDDAssertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParserTest {

	@DisplayName("parse 메서드에 정상적인(Validator를 통과하는) 값을 전달하면 ParseResult 객체를 반환한다.")
	@ParameterizedTest
	@ValueSource(strings = {"2 + 3 * 4 / 2", "2 + 3 * 4 + 5 - 3 * 2", "3 + 4"})
	void parse(String value) {

		//when
		ParseResult result = Parser.parse(value);

		//then
		then(result).isInstanceOf(ParseResult.class);

	}

	@DisplayName("parse 메서드에 비정상적인(Validator를 통과 못하는) 값을 전달하면 IllegalArgumentException이 발생한다.")
	@ParameterizedTest
	@ValueSource(strings = {"2+3*4/2", "3   4", "2  +    5"})
	void parseThrow(String value) {

		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				Parser.parse(value);
			});

	}

}