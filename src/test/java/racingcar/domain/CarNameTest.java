package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import exception.OutOfRangeException;

class CarNameTest {
	@DisplayName("자동차의 이름 5글자 초과X")
	@ValueSource(strings = {"six666"})
	@ParameterizedTest
	public void When_CarNameOverFiveLength_Expected_OutOfRangeException(String carName) {

		assertThatThrownBy(() -> new CarName(carName))
			.isInstanceOf(OutOfRangeException.class);
	}

	@DisplayName("자동차의 이름 빈문자열 X")
	@ValueSource(strings = {""})
	@ParameterizedTest
	public void When_CarNameEmptyString_Expected_OutOfRangeException(String carName) {

		assertThatThrownBy(() -> new CarName(carName))
			.isInstanceOf(OutOfRangeException.class);
	}
}