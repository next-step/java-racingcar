package game;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

	List<RacingCar> racingCars;

	@BeforeEach
	void init() {
		RacingCar racingCar1 = new RacingCar("racingCar1");
		RacingCar racingCar2 = new RacingCar("racingCar2");
		RacingCar racingCar3 = new RacingCar("racingCar3");
		RacingCar racingCar4 = new RacingCar("racingCar4");

		MovingDistanceWrapper movingDistanceWrapper = new MovingDistanceWrapper();

		racingCars = Arrays.asList(racingCar1, racingCar2, racingCar3, racingCar4);
	}

	@Test
	@DisplayName("최대값_구하기")
	void find_RacingCarsMaxDistance() {

	}

}