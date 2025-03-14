package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RaceControllerTest {

	@Test
	@DisplayName("1 이상의 정수(올바른 입력)이면 입력값을 정수로 반환한다.")
	void parseValidIntTest_validInput() {
		// given
		int inputInteger = 5;
		String input = inputInteger + "\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		RaceController raceController = new RaceController();

		// when
		int result = raceController.parseValidInt();

		// then
		Assertions.assertThat(result)
			.isEqualTo(inputInteger);
	}

	@Test
	@DisplayName("1 미만의 정수를 입력하면 예외를 반환한다.")
	void parseValidIntTest_integerLessThanOne_throwsException() {
		// given
		int inputInteger = -1;
		String input = inputInteger + "\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		RaceController raceController = new RaceController();

		// when & then
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(raceController::parseValidInt)
			.withMessageContaining("1 이상의 정수만 입력할 수 있습니다.");
	}

	@Test
	@DisplayName("정수가 아닌 값을 입력하면 예외를 반환한다.")
	void parseValidIntTest_notInteger_throwsException() {
		// given
		String input = "Not Integer\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		RaceController raceController = new RaceController();

		// when & then
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(raceController::parseValidInt)
			.withMessageContaining("정수만 입력할 수 있습니다.");
	}

	@ParameterizedTest
	@ValueSource(strings = {"   ", ""})
	@DisplayName("입력값이 존재하지 않으면 예외를 반환한다.")
	void parseValidIntTest_noInput_throwsException(String input) {
		// given
		InputStream in = new ByteArrayInputStream((input + "\n").getBytes());
		System.setIn(in);
		RaceController raceController = new RaceController();

		// when & then
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(raceController::parseValidInt)
			.withMessageContaining("입력값이 존재하지 않습니다.");
	}
}
