package racingCar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RacingTest {
	@Test
	@DisplayName("레이싱 참가자 수 테스트")
	void participantOfRacing() throws Exception {
		Cars actual = Racing.participate("3");
		assertThat(actual.getCars().size()).isEqualTo(3);
	}

	@ParameterizedTest
	@DisplayName("레이싱 참가자 수 음수 또는 문자 확인")
	@CsvSource(value = {
		"a",
		"-1"
	})
	void checkInput(String input) {
		assertThatThrownBy(() -> Racing.checkInput(input))
			.isInstanceOf(RuntimeException.class);
	}
}
