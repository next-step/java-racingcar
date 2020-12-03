package com.woowahan.racing.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.woowahan.racing.constant.Message;

class InputResultTest {

	@DisplayName("of 메서드는 InputResult 인스턴스를 반환한다.")
	@CsvSource(value = {"3:5", "1:9", "2:10"}, delimiter = ':')
	@ParameterizedTest
	void of(int carCount, int tryCount) {

		InputResult result = InputResult.of(carCount, tryCount);
		assertThat(result).isInstanceOf(InputResult.class);
	}

	@DisplayName("of 메서드는 두개의 인자 중 하나의 인자라도 0과 같거나 작은 값을 전달 받는 경우 IllegalArgumentException을 발생시킨다.")
	@ParameterizedTest
	@CsvSource(value = {"0:5", "5:0", "-1:5", "5:-1", "0:0", "-1:-1", "-5:7", "7:-5"}, delimiter = ':')
	void ofThrow(int carCount, int tryCount) {

		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				InputResult.of(carCount, tryCount);
			}).withMessageMatching(Message.MSG_POSITIVE_NUMBER);
	}

	@DisplayName("getter 메서드는 Instance 생성할 때 전달한 파라미터와 값이 동일하다.")
	@ParameterizedTest
	@CsvSource(value = {"3:5", "1:9", "2:10"}, delimiter = ':')
	void getter(int carCount, int tryCount) {
		InputResult result = InputResult.of(carCount, tryCount);

		assertAll(
			() -> assertThat(result.getCarCount()).isEqualTo(carCount),
			() -> assertThat(result.getTryCount()).isEqualTo(tryCount)
		);
	}

}