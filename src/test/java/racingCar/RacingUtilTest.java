package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingUtilTest {

	@RepeatedTest(10)
	@DisplayName("getRandomNumber_isBetween 0~9_true")
	void getRandomNumber() {
		assertThat(RacingUtil.getRandomNumber()).isBetween(0, 9);
	}
}
