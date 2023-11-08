package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racingCar.RacingCar.*;

public class RacingCarTest {

	@RepeatedTest(10)
	@DisplayName("getRandomNumber_isBetween 0~9_true")
	void randomRange() {
		assertThat(getRandomNumber()).isBetween(0, 9);
	}

	@ParameterizedTest
	@CsvSource({"3,false", "4,true"})
	@DisplayName("canMove_0~9 사이의 숫자_boolean")
	void 전진여부_결정(int randomNumber, boolean result) {
		assertThat(canMove(randomNumber)).isEqualTo(result);
	}

	@ParameterizedTest
	@CsvSource({"1,1", "2,2", "3,3"})
	void Car_생성테스트(int input, int expected) {
		assertThat(RacingCar.getCarList(input)).hasSize(expected);
	}
}
