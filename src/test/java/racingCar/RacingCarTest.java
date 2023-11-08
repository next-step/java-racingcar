package racingCar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static racingCar.RacingCar.canMove;
import static racingCar.RacingCar.getRandomNumber;

public class RacingCarTest {

	@RepeatedTest(10)
	@DisplayName("getRandomNumber_isBetween 0~9_true")
	void randomRange() {
		assertThat(getRandomNumber()).isBetween(0, 9);
	}
	
}
